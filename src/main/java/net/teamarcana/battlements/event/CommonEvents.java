package net.teamarcana.battlements.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.teamarcana.battlements.Battlements;

import static net.teamarcana.battlements.Battlements.TRAIT_REGISTRY;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void registerRegistry(NewRegistryEvent event) {
        Battlements.LOGGER.debug("Registering Traits");
        event.register(TRAIT_REGISTRY);
    }
}
