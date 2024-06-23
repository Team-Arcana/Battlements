package net.teamarcana.battlements.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.weapon_trait.Trait;

public class BattleTraits {
    public static final ResourceKey<Registry<Trait>> REGISTRY_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "weapon_traits"));
    public static final Registry<Trait> TRAIT_REGISTRY = new RegistryBuilder<Trait>(REGISTRY_KEY).create();

    public static final DeferredRegister<Trait> WEAPON_TRAITS = DeferredRegister.create(REGISTRY_KEY, Battlements.MOD_ID);



    public static void register(IEventBus eventBus){
        WEAPON_TRAITS.register(eventBus);
    }
}
