package net.teamarcana.battlements.mob_effects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class BattleMobEffect extends MobEffect {
    public BattleMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public BattleMobEffect(MobEffectCategory category, int color, ParticleOptions particle) {
        super(category, color, particle);
    }
}
