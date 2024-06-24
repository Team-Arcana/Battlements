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
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> BattleItems.CREATIVE_ICON.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                // WOOD TIER


                // STONE TIER


                // GOLD TIER


                // IRON TIER
                output.accept(BattleItems.IRON_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_LONGSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_SABER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_GREATCLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_WARHAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_MAUL.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_MACE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_WARPICK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_GREATAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_HALBERD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_PIKE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_PITCHFORK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_KUNAI.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_TOMAHAWK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_THROWING_KNIFE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // STEEL TIER


                // DIAMOND TIER


                // NETHERITE TIER


                // ENDERIUM TIER

            }).build());


    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(Items.STICK.getDefaultInstance(),
                    BattleItems.HANDLE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(BattleItems.HANDLE.get().getDefaultInstance(),
                    BattleItems.POLE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(BattleItems.POLE.get().getDefaultInstance(),
                    BattleItems.ROCK.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.NETHERITE_INGOT.getDefaultInstance(),
                    BattleItems.ENDER_CRYSTAL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(BattleItems.ENDER_CRYSTAL.get().getDefaultInstance(),
                    BattleItems.ENDERIUM_INGOT.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.IRON_INGOT.getDefaultInstance(),
                    BattleItems.STEEL_INGOT.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.COPPER_INGOT.getDefaultInstance(),
                    BattleItems.COPPER_NUGGET.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.DIAMOND.getDefaultInstance(),
                    BattleItems.DIAMOND_SHARD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }
        //if(event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS)
    }

    public static void register(IEventBus eventBus){ CREATIVE_MODE_TABS.register(eventBus); }
}
