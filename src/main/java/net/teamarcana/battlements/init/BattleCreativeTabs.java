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
                // -- Melee Weapons --
                // Battleaxes
                output.accept(BattleItems.STONE_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Anchors
                output.accept(BattleItems.GOLDEN_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Hammers
                output.accept(BattleItems.GOLDEN_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Clubs
                output.accept(BattleItems.WOODEN_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.BONE_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Katanas
                output.accept(BattleItems.GOLDEN_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Rapiers
                output.accept(BattleItems.GOLDEN_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Cutlasses
                output.accept(BattleItems.WOODEN_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Daggers
                output.accept(BattleItems.FLINT_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.BONE_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Greatswords
                output.accept(BattleItems.STONE_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Claws
                output.accept(BattleItems.FLINT_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Sickles
                output.accept(BattleItems.GOLDEN_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Spears
                output.accept(BattleItems.FLINT_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Quarterstaves
                output.accept(BattleItems.WOODEN_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Glaives
                output.accept(BattleItems.STONE_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Scythes
                output.accept(BattleItems.WOODEN_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // -- Ranged Weapons --



                // -- Throwing Weapons --

                // Javelins
                output.accept(BattleItems.FLINT_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // Boomerangs
                output.accept(BattleItems.WOODEN_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.IRON_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);


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
