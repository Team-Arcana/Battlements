package net.teamarcana.battlements.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BattleCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Battlements.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WEAPON_TAB = CREATIVE_MODE_TABS.register("battle_combat", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.battlements")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> BattleItems.CREATIVE_ICON.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                //output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());


    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        /*
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(EXAMPLE_BLOCK_ITEM);

         */
    }

    public static void register(IEventBus eventBus){ CREATIVE_MODE_TABS.register(eventBus); }
}
