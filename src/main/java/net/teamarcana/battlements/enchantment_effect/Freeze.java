package net.teamarcana.battlements.enchantment_effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record Freeze(LevelBasedValue duration) implements EnchantmentEntityEffect {
    public static final MapCodec<Freeze> CODEC = RecordCodecBuilder.mapCodec(
            codecInstance -> codecInstance.group(LevelBasedValue.CODEC.fieldOf("duration").forGetter(p_345622_ -> p_345622_.duration)).apply(codecInstance, Freeze::new)
    );

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity target, Vec3 position) {
        target.setTicksFrozen(40 * Mth.floor(this.duration.calculate(enchantmentLevel)));
        /*
        if(!target.level().isClientSide() && target.tickCount % 40 == 0){
            target.hurt(target.damageSources().freeze(), 1.0f);
        }
        */
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
