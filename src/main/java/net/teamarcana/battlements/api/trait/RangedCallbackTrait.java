package net.teamarcana.battlements.api.trait;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Tier;
import net.teamarcana.battlements.api.trait.callback.IRangedCallback;

import java.util.Optional;

public class RangedCallbackTrait extends Trait implements IRangedCallback {
    /**
     * The constructor for the Trait
     *
     * @param name    the name of the trait
     * @param modId   the mod ID that the trait is registered from
     * @param quality the trait's quality. Can be "positive", "neutral", or "negative"
     */
    public RangedCallbackTrait(String name, String modId, String quality) { super(name, modId, quality); }
    @Override
    public Optional<IRangedCallback> getRangedCallback() { return Optional.of(this); }
    @Override
    public void onProjectileSpawn(Tier tier, AbstractArrow projectile){};
    @Override
    public float modifyChargeTime(Tier tier, float baseCharge){ return baseCharge; }
}
