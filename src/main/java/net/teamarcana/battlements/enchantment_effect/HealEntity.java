package net.teamarcana.battlements.enchantment_effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record HealEntity(LevelBasedValue amount) implements EnchantmentEntityEffect {
    public static final MapCodec<HealEntity> CODEC = RecordCodecBuilder.mapCodec(
            codecInstance -> codecInstance.group(
                            LevelBasedValue.CODEC.fieldOf("amount").forGetter(HealEntity::amount)
                    )
                    .apply(codecInstance, HealEntity::new)
    );

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity target, Vec3 position) {
        item.owner().heal(amount.calculate(enchantmentLevel));
    }

    @Override
    public MapCodec<HealEntity> codec() {
        return CODEC;
    }
}
