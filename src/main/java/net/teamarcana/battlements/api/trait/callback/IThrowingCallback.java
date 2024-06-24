package net.teamarcana.battlements.api.trait.callback;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Tier;

/**
 * Callback thingy for throwing traits
 * implement this when making a trait to add some custom behaviors
 */
public interface IThrowingCallback {
    public default int modifyChargeTime(Tier tier, int baseCharge){ return baseCharge; }
    public default void onThrowingProjectileSpawn(Tier tier, AbstractArrow projectile){}
}
