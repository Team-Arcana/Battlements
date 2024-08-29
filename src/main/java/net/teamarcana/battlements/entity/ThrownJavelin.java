package net.teamarcana.battlements.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.teamarcana.battlements.init.BattleItems;

public class ThrownJavelin extends AbstractThrownWeapon {
    // constructors
    public ThrownJavelin(EntityType<? extends AbstractThrownWeapon> type, Level level) {
        super(type, level);
    }
    public ThrownJavelin(EntityType<? extends AbstractThrownWeapon> type, Level level, double x, double y, double z, ItemStack weapon){
        super(type, level, x, y, z, weapon);
    }
    public ThrownJavelin(EntityType<? extends AbstractThrownWeapon> type, Level level, LivingEntity shooter, ItemStack weapon){
        super(type, level, shooter, weapon);
    }

    @Override
    public SoundEvent getMobHitSound() {
        return SoundEvents.TRIDENT_HIT;
    }
    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(BattleItems.FLINT_JAVELIN.get());
    }
}
