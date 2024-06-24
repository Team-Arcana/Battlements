package net.teamarcana.battlements.api.trait;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Tier;
import net.teamarcana.battlements.api.trait.callback.IThrowingCallback;

import java.util.Optional;

public class ThrowingCallbackTrait extends Trait implements IThrowingCallback {
    /**
     * The constructor for the Trait
     *
     * @param name    the name of the trait
     * @param modId   the mod ID that the trait is registered from
     * @param quality the trait's quality. Can be "positive", "neutral", or "negative"
     */
    public ThrowingCallbackTrait(String name, String modId, String quality) {
        super(name, modId, quality);
    }

    @Override
    public Optional<IThrowingCallback> getThrowingCallback() {
        return Optional.of(this);
    }

    @Override
    public int modifyChargeTime(Tier tier, int baseCharge){ return baseCharge; }
    @Override
    public void onThrowingProjectileSpawn(Tier tier, AbstractArrow projectile){}
}
