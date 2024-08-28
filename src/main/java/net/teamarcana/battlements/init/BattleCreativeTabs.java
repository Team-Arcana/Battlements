package net.teamarcana.battlements.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
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
            .icon(() -> BattleItems.DIAMOND_BATTLEAXE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                // Battleaxes
                output.accept(BattleItems.STONE_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            }).build());


    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(Items.IRON_INGOT.getDefaultInstance(), BattleItems.STEEL_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.IRON_NUGGET.getDefaultInstance(), BattleItems.STEEL_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GOLD_NUGGET.getDefaultInstance(), BattleItems.DIAMOND_SHARD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(BattleItems.DIAMOND_SHARD.get().getDefaultInstance(), BattleItems.NETHERITE_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT){
            event.insertAfter(Items.IRON_SWORD.getDefaultInstance(), BattleItems.STEEL_SWORD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.IRON_AXE.getDefaultInstance(), BattleItems.STEEL_AXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.insertAfter(Items.IRON_HOE.getDefaultInstance(), BattleItems.STEEL_SHOVEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(BattleItems.STEEL_SHOVEL.get().getDefaultInstance(), BattleItems.STEEL_PICKAXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(BattleItems.STEEL_PICKAXE.get().getDefaultInstance(), BattleItems.STEEL_AXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(BattleItems.STEEL_AXE.get().getDefaultInstance(), BattleItems.STEEL_HOE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    public static void register(IEventBus eventBus){ CREATIVE_MODE_TABS.register(eventBus); }
}
