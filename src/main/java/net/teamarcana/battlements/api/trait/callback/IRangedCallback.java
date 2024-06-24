package net.teamarcana.battlements.api.trait.callback;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Tier;

/**
 * callback class for ranged traits
 */
public interface IRangedCallback {
    public default void onProjectileSpawn(Tier tier, AbstractArrow projectile){};
    public default float modifyChargeTime(Tier tier, float baseCharge){ return baseCharge; }
}
