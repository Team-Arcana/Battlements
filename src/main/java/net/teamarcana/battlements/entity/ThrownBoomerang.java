package net.teamarcana.battlements.entity;

import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.teamarcana.battlements.init.BattleItems;
import net.teamarcana.battlements.init.BattleSounds;

import java.util.UUID;

public class ThrownBoomerang extends AbstractThrownWeapon {
    public static float distanceToReturn = 5;
    protected double maxDistance = distanceToReturn;
    protected final float acceleration = 0.1f;

    protected final int ticksPerSound = 5;
    protected int ticksUntilSound = 0;
    protected Vec3 throwerPosition = null;

    protected LivingEntity thrower;
    private UUID throwerID;
    protected boolean isReturning = false;

    // NBT Stuff
    protected final String throwerTag = "thrower";

    // constructors
    public ThrownBoomerang(EntityType<? extends AbstractThrownWeapon> type, Level level) {
        super(type, level);
        initialize();
    }
    public ThrownBoomerang(EntityType<? extends AbstractThrownWeapon> type, Level level, double x, double y, double z, ItemStack weapon){
        super(type, level, x, y, z, weapon);
        initialize();
    }
    public ThrownBoomerang(EntityType<? extends AbstractThrownWeapon> type, Level level, LivingEntity shooter, ItemStack weapon){
        super(type, level, shooter, weapon);
        this.throwerID = shooter.getUUID();
        initialize();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
    }

    @Override
    public SoundEvent getMobHitSound() {
        return BattleSounds.BOOMERANG_HIT_ENTITY.get();
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return BattleSounds.BOOMERANG_HIT_BLOCK.get();
    }

    protected void initialize(){
        setNoGravity(true);
    }

    public void setReturnDistance(double distance){ maxDistance = distance; }

    @Override
    public void tick() {
        super.tick();

        // do nothing if it hits the ground
        if(inGround){
            xRotO = getXRot();
            yRotO = getYRot();
            return;
        }

        getReturnPosition(getOwner());
        // get the position of the thrower, and the distance between the boomerang and its thrower
        double dist = -1;
        if(throwerPosition != null){
            dist = throwerPosition.distanceTo(position());
        }

        if(isNoGravity()){
            if((dist < 1 && returning()) || (isInWater() && waterInertia <= 0)){ setNoGravity(false); }
            if(dist > maxDistance && !returning()){ setReturning(true); }

            if(returning() && throwerPosition != null){
                Vec3 distance = position().subtract(throwerPosition);
                double length = distance.length();

                if(length < 5){ setDeltaMovement(-distance.x() / length, -distance.y() / length, -distance.z() / length); }
                else{ setDeltaMovement(getDeltaMovement().add(-acceleration * (distance.x() / length), -acceleration * (distance.y() / length), -acceleration * (distance.z() / length))); }
            }

            // play the funny sound on loop
            if(ticksUntilSound <= 0 && !isNoPhysics()){
                ticksUntilSound = ticksPerSound;
                if(!level().isClientSide()){
                    level().playSound(null, getX(), getY(), getZ(), BattleSounds.BOOMERANG_FLY.get(), SoundSource.NEUTRAL, 2, 0.5f);
                }
            }
            --ticksUntilSound;
        }
        if(!level().isClientSide() && tickCount > 200){
            if(getEntityData().get(RETURN_DATA) && !isNoPhysics()){
                setNoPhysics(true);
            }
            else if(pickup == Pickup.ALLOWED){
                //dropAsItem();
                //if(getThrower() instanceof Player player){ tryPickup(player); }
                discard();
            }
        }
    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);
        setReturning(true);
    }

    protected void getReturnPosition(Entity thrower){
        if(thrower != null){ throwerPosition = new Vec3(thrower.getX(), thrower.getY() + (thrower.getEyeHeight() * 0.9d) - 0.1d, thrower.getZ()); }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        //this.thrower = getThrower();
        if(isNoGravity()){
            // I cannot believe Calculus 3 has actually helped me with this
            //  what follows is an attempt to calculate where the boomerang will ricochet off the block
            Vec3i face = result.getDirection().getNormal();
            Vec3 faceVector = new Vec3(face.getX(), face.getY(), face.getZ()).normalize();
            Vec3 motion = getDeltaMovement();

            Vec3 reflect = faceVector.scale(2 * motion.dot(faceVector)).subtract(motion);
            setDeltaMovement(reflect.scale(-0.75));
            playSound(BattleSounds.BOOMERANG_HIT_BLOCK.get(), 1, 2.2f / random.nextFloat() * 0.2f + 0.9f);
        }  else{ super.onHitBlock(result); }
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        this.thrower = getThrower();
    }

    public LivingEntity getThrower(){
        if(this.thrower == null && this.throwerID != null && this.level() instanceof ServerLevel serverLevel){
            Entity e = serverLevel.getEntity(this.throwerID);
            if(e instanceof LivingEntity entity){
                this.thrower = entity;
            } else {
                this.throwerID = null;
            }
        }
        return this.thrower;
    }

    @Override
    public void playerTouch(Player entity) {
        if (this.ownedBy(entity) || this.getOwner() == null) {
            if (!this.level().isClientSide && (inGround || isReturning()) && this.shakeTime <= 0) {
                if (this.tryPickup(entity)) {
                    entity.take(this, 1);
                    this.discard();
                }
            }
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if(tag.contains(throwerTag, 10)){
            Tag owner = tag.get(throwerTag);
            if(owner != null){ this.throwerID = NbtUtils.loadUUID(owner); }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if(this.thrower != null){ tag.put(throwerTag, NbtUtils.createUUID(this.throwerID)); }
    }

    @Override
    public void setReturning(Boolean bool) {
        super.setReturning(bool);
        isReturning = bool;
    }
    public boolean returning() { return isReturning; }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(BattleItems.WOODEN_BOOMERANG.get());
    }
}
