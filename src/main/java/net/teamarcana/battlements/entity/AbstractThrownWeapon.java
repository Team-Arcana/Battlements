package net.teamarcana.battlements.entity;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.teamarcana.battlements.api.archetype.Archetype;
import net.teamarcana.battlements.item.BaseWeaponItem;
import net.teamarcana.battlements.item.ThrowingWeaponItem;
import org.jetbrains.annotations.Nullable;

public class AbstractThrownWeapon extends AbstractArrow{
    private static final EntityDataAccessor<ItemStack> WEAPON_DATA = SynchedEntityData.defineId(AbstractThrownWeapon.class, EntityDataSerializers.ITEM_STACK);
    public static final EntityDataAccessor<Boolean> RETURN_DATA = SynchedEntityData.defineId(AbstractThrownWeapon.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HYDRO_DATA = SynchedEntityData.defineId(AbstractThrownWeapon.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Byte> LOYALTY_DATA = SynchedEntityData.defineId(AbstractThrownWeapon.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> FOIL_DATA = SynchedEntityData.defineId(AbstractThrownWeapon.class, EntityDataSerializers.BOOLEAN);

    private ItemStack weapon;
    private float baseDamage = 0;

    private int life;
    protected int airTicks = 0;
    protected float waterInertia = 0.0f;
    protected boolean returning = false;

    protected boolean playedSound = false;

    protected final String weaponTag = "weapon";
    protected final String damageTag  = "DealtDamage";

    private Entity thrower;

    private boolean dealtDamage;
    public int clientSideReturnWeaponTickCount;


    // constructors
    public AbstractThrownWeapon(EntityType<? extends AbstractThrownWeapon> type, Level level) {
        super(type, level);
    }
    public AbstractThrownWeapon(EntityType<? extends AbstractThrownWeapon> entityType, Level level, LivingEntity shooter, ItemStack item){
        super(entityType, shooter, level, item, null);
        this.weapon = item.copy();
        this.entityData.set(LOYALTY_DATA, this.getLoyaltyFromItem(item));
        this.entityData.set(FOIL_DATA, item.hasFoil());
    }
    public AbstractThrownWeapon(EntityType<? extends AbstractThrownWeapon> entityType, Level level, double x, double y, double z, ItemStack item) {
        super(entityType, x, y, z, level, item, item);
        this.weapon = item.copy();
        this.entityData.set(LOYALTY_DATA, this.getLoyaltyFromItem(item));
        this.entityData.set(FOIL_DATA, item.hasFoil());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(WEAPON_DATA, ItemStack.EMPTY);
        builder.define(RETURN_DATA, false);
        builder.define(HYDRO_DATA, false);
        builder.define(LOYALTY_DATA, ((byte) 0));
        builder.define(FOIL_DATA, false);
    }

    @Override
    public void tick(){
        if(waterInertia == 0.0f){ waterInertia = 0.98f; }

        Entity owner = getOwner();
        if((this.inGroundTime > 4 || returning) && owner != null){
            int rLevel = getEntityData().get(LOYALTY_DATA);
            if(rLevel > 0){
                if(this.isAcceptableReturnOwner()){
                    if(!isReturning()){
                        setNoPhysics(true);
                        inGround = false;
                        setReturning(true);
                        setNoGravity(true);
                    }

                    Vec3 v = owner.getEyePosition().subtract(this.position());
                    this.setPosRaw(this.getX(), this.getY() + v.y * 0.015d * (double) rLevel, this.getZ());
                    if(this.level().isClientSide()){ this.yOld = this.getY(); }

                    Double d = 0.05d * (double) rLevel;
                    this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(v.normalize().scale(d)));
                    if(!playedSound){
                        this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
                        playedSound = true;
                    }
                } else if(rLevel > 0 && !owner.isAlive()){
                    setNoPhysics(false);
                    setReturning(false);
                    setNoGravity(false);
                    getEntityData().set(LOYALTY_DATA, (byte) 0);
                }
            }
        }

        super.tick();
        if(!inGround){ ++airTicks; }
        else if(airTicks != 0){ airTicks = 0; }
    }

    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        return entity != null && entity.isAlive() && (!(entity instanceof ServerPlayer) || !entity.isSpectator());
    }
    public boolean isFoil() {
        return this.entityData.get(FOIL_DATA);
    }

    @javax.annotation.Nullable
    @Override
    protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
        return this.dealtDamage ? null : super.findHitEntity(startVec, endVec);
    }

    /*
    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity target = result.getEntity();
        Entity owner = getOwner();
        if(target != null){
            ItemStack item = this.getWeapon();
            float dmg = (float) Math.ceil(getBaseDamage());
            DamageSource source = this.damageSources().trident(this, (Entity) owner == null ? this : target);

            if(isCritArrow()){ dmg += random.nextInt((int)dmg / 2 + 2); }
            if(owner != null && (canCatchInAir(owner, target) || isReturning()) && target instanceof Player player){ if(tryToCatch(player)){ return; } }

            if(target.hurt(source, dmg)){
                if(target.getType() == EntityType.ENDERMAN){
                    return;
                }

                SoundEvent sound = this.getMobHitSound();
                playSound(sound, 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
            }else{
                setDeltaMovement(getDeltaMovement().scale(-0.1));
                setYRot(getYRot() + 180);
                yRotO += 180;
                airTicks = 0;

                if(!level().isClientSide() && getDeltaMovement().lengthSqr() < 1.0e-7d){
                    if(getEntityData().get(LOYALTY_DATA) > 0 && !isNoPhysics()){ setNoPhysics(true); }
                    else if(pickup == Pickup.ALLOWED){ dropAsItem(); discard(); }
                }
            }
        } else {
            super.onHitEntity(result);
        }

    }
     */

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(this.getWeapon().getItem() instanceof ThrowingWeaponItem weaponItem){
            baseDamage = ((weaponItem.getTier().getAttackDamageBonus() * weaponItem.getArchetype().getAttackDamageMultiplier()) + (weaponItem.getArchetype().getBaseAttackDamage()/ 0.4f));
        }
        Entity target = result.getEntity();
        float f = 0;
        Entity owner = this.getOwner();


        DamageSource damagesource = this.damageSources().trident(this, (Entity)(owner == null ? this : owner));
        if(owner instanceof Mob mob){ damagesource = this.damageSources().mobAttack(mob); }
        if(owner instanceof Player player){ damagesource = this.damageSources().playerAttack(player); }


        if (this.level() instanceof ServerLevel serverlevel) {
            f = EnchantmentHelper.modifyDamage(serverlevel, this.getWeaponItem(), target, damagesource, baseDamage);
        }

        if(owner != null && (canCatchInAir(owner, target) || isReturning()) && target instanceof Player player){ if(tryPickup(player)){ return; } }

        this.dealtDamage = true;
        if (target.hurt(damagesource, f)) {
            if (target.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (this.level() instanceof ServerLevel serverlevel1) {
                EnchantmentHelper.doPostAttackEffectsWithItemSource(serverlevel1, target, damagesource, this.getWeaponItem());
            }

            if (target instanceof LivingEntity livingentity) {
                this.doKnockback(livingentity, damagesource);
                this.doPostHurtEffects(livingentity);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01, -0.1, -0.01));
        SoundEvent sound = this.getMobHitSound();
        this.playSound(sound, 1.0F, 1.0F);
    }

    @Override
    protected void hitBlockEnchantmentEffects(ServerLevel pLevel, BlockHitResult pHitResult, ItemStack pStack) {
        Vec3 vec3 = pHitResult.getBlockPos().clampLocationWithin(pHitResult.getLocation());
        EnchantmentHelper.onHitBlock(
                pLevel,
                pStack,
                this.getOwner() instanceof LivingEntity livingentity ? livingentity : null,
                this,
                null,
                vec3,
                pLevel.getBlockState(pHitResult.getBlockPos()),
                p_348680_ -> this.kill()
        );
    }

    @Override
    public ItemStack getWeaponItem() {
        return getEntityData().get(WEAPON_DATA);
    }
    public AbstractThrownWeapon setWeapon(ItemStack item){
        ItemStack itemStack = item.copy();
        getEntityData().set(WEAPON_DATA, itemStack);
        getEntityData().set(LOYALTY_DATA, this.getLoyaltyFromItem(item));
        return this;
    }

    @Override
    protected boolean tryPickup(Player player) {
        return super.tryPickup(player) || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.ARROW);
    }

    @Override
    public void playerTouch(Player entity) {
        if (this.ownedBy(entity) || this.getOwner() == null || isReturning()) {
            super.playerTouch(entity);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.dealtDamage = tag.getBoolean("DealtDamage");
        this.entityData.set(LOYALTY_DATA, this.getLoyaltyFromItem(this.getPickupItemStackOrigin()));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("DealtDamage", this.dealtDamage);
    }

    private byte getLoyaltyFromItem(ItemStack item) {
        return this.level() instanceof ServerLevel serverlevel
                ? (byte)Mth.clamp(EnchantmentHelper.getTridentReturnToOwnerAcceleration(serverlevel, item, this), 0, 127)
                : 0;
    }

    @Override
    protected void tickDespawn() {
        int i = this.entityData.get(LOYALTY_DATA);
        if (this.pickup != AbstractArrow.Pickup.ALLOWED || i <= 0) {
            super.tickDespawn();
        }
    }

    @Override
    public boolean shouldRender(double x, double y, double z) {
        return super.shouldRender(x, y, z);
    }



    @Override
    public void setOwner(@Nullable Entity owner) {
        this.thrower = owner;
        super.setOwner(owner);
    }

    @Nullable
    @Override
    public Entity getOwner() {
        if(thrower != null) return thrower;
        return super.getOwner();
    }

    public boolean isValid(){ return !getWeaponItem().isEmpty() && getWeaponItem() != null; }
    protected boolean canCatchInAir(Entity thrower, Entity hitEntity){ return thrower == hitEntity && isNoPhysics(); }
    public int getAirTicks() { return airTicks; }
    public SoundEvent getMobHitSound() { return SoundEvents.TRIDENT_HIT; }
    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() { return SoundEvents.TRIDENT_HIT_GROUND; }


    public boolean isReturning(){ return returning; }
    public void setReturning(Boolean bool){
        returning = bool;
        getEntityData().set(RETURN_DATA, bool);
    }

    @Override
    public void onAddedToLevel() {
        thrower = this.getOwner();
        super.onAddedToLevel();
    }

    private boolean isAcceptableReturnOwner(){
        Entity owner = this.getOwner();
        return owner != null && owner.isAlive() && (!(owner instanceof ServerPlayer) || !owner.isSpectator());
    }

    @Override
    public void shoot(double pX, double pY, double pZ, float pVelocity, float pInaccuracy) {
        super.shoot(pX, pY, pZ, pVelocity, pInaccuracy);
        this.life = 0;
    }

    @Override
    public void lerpMotion(double pX, double pY, double pZ) {
        super.lerpMotion(pX, pY, pZ);
        this.life = 0;
    }

    @Override
    protected float getWaterInertia() {
        return waterInertia > 0.0f ? waterInertia : super.getWaterInertia();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        Level level = level();
        if(result.getType() == HitResult.Type.BLOCK){
            if(!level.isClientSide){
                BlockState s = level.getBlockState(result.getBlockPos());
                ((ServerLevel) level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, s).setPos(result.getBlockPos()), getX(), getY(), getZ(), 5, 0.1d, 0.1d, 0.1d, 0.05d);
            }
        }
        super.onHitBlock(result);
    }

    public ItemStack getWeapon() {
        return getPickupItem();
    }

    @Override
    protected ItemStack getPickupItem() {
        return getEntityData().get(WEAPON_DATA);
    }

    public AbstractThrownWeapon setBaseDamage(float damage){
        this.baseDamage = damage;
        return this;
    }
}
