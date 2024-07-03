package net.teamarcana.battlements.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.enchantment_effect.Freeze;
import net.teamarcana.battlements.enchantment_effect.HealEntity;

public class BattleEnchantmentEntityEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCHANTMENT_ENTITY_EFFECTS = DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Battlements.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<HealEntity>> HEAL_ENTITY = ENCHANTMENT_ENTITY_EFFECTS.register("heal_entity", ()-> HealEntity.CODEC);
    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<Freeze>> FREEZE = ENCHANTMENT_ENTITY_EFFECTS.register("freeze", ()-> Freeze.CODEC);

    public static void register(IEventBus eventBus){ ENCHANTMENT_ENTITY_EFFECTS.register(eventBus); }
}
