package net.teamarcana.battlements.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.teamarcana.battlements.init.BattleTraits;
import net.teamarcana.battlements.init.BattleWeaponTypes;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void registerRegistries(NewRegistryEvent event) {
        event.register(BattleTraits.TRAIT_REGISTRY);
        event.register(BattleWeaponTypes.WEAPON_TYPE_REGISTRY);
    }
}
