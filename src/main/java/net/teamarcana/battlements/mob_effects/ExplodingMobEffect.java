package net.teamarcana.battlements.mob_effects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ExplodingMobEffect extends BattleMobEffect{
    public ExplodingMobEffect() {
        super(MobEffectCategory.HARMFUL, 0xf69f2c);
    }
    public ExplodingMobEffect(ParticleOptions particle) {
        super(MobEffectCategory.HARMFUL, 0xf69f2c, particle);
    }

    @Override
    public void onMobRemoved(LivingEntity livingEntity, int amplifier, Entity.RemovalReason reason) {
        if (reason == Entity.RemovalReason.KILLED) {
            Level level = livingEntity.level();
            if (!level.isClientSide) {
                livingEntity.level().explode(livingEntity, livingEntity.getOnPos().getX(),
                        livingEntity.getOnPos().getY(),
                        livingEntity.getOnPos().getZ(), (float)3 * (amplifier + 1), Level.ExplosionInteraction.MOB);
            }
        }
    }
}
