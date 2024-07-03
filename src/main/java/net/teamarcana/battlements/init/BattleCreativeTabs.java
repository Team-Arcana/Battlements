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
                output.accept(BattleItems.WOODEN_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_LONGSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_SABER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_GREATCLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_WARHAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_MAUL.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_WARPICK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_GREATAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_HALBERD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_PIKE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_PITCHFORK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_KUNAI.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_TOMAHAWK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.WOODEN_THROWING_KNIFE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // STONE TIER
                output.accept(BattleItems.STONE_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_LONGSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_SABER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_GREATCLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_WARHAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_MAUL.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_WARPICK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_GREATAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_HALBERD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_PIKE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_PITCHFORK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_KUNAI.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_TOMAHAWK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STONE_THROWING_KNIFE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // GOLD TIER
                output.accept(BattleItems.GOLDEN_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_LONGSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_SABER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_GREATCLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_WARHAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_MAUL.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_WARPICK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_GREATAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_HALBERD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_PIKE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_PITCHFORK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_KUNAI.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_TOMAHAWK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.GOLDEN_THROWING_KNIFE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

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
                output.accept(BattleItems.STEEL_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_LONGSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_SABER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_GREATCLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_WARHAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_MAUL.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_WARPICK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_GREATAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_HALBERD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_PIKE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_PITCHFORK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_KUNAI.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_TOMAHAWK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.STEEL_THROWING_KNIFE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // DIAMOND TIER
                output.accept(BattleItems.DIAMOND_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_LONGSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_SABER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_GREATCLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_WARHAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_MAUL.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_WARPICK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_GREATAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_HALBERD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_PIKE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_PITCHFORK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_KUNAI.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_TOMAHAWK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.DIAMOND_THROWING_KNIFE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // NETHERITE TIER
                output.accept(BattleItems.NETHERITE_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_LONGSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_SABER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_GREATCLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_WARHAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_MAUL.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_WARPICK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_GREATAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_HALBERD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_PIKE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_PITCHFORK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_KUNAI.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_TOMAHAWK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.NETHERITE_THROWING_KNIFE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                // ENDERIUM TIER
                output.accept(BattleItems.ENDERIUM_DAGGER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_LONGSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_GREATSWORD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_KATANA.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_RAPIER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_SABER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_CUTLASS.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_SICKLE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_CLAW.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_CLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_GREATCLUB.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_HAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_WARHAMMER.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_MAUL.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_ANCHOR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_WARPICK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_BATTLEAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_GREATAXE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_HALBERD.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_SPEAR.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_PIKE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_GLAIVE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_QUARTERSTAFF.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_PITCHFORK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_SCYTHE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_JAVELIN.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_BOOMERANG.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_KUNAI.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_TOMAHAWK.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                output.accept(BattleItems.ENDERIUM_THROWING_KNIFE.get(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
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

            event.getEntries().putAfter(Items.IRON_INGOT.getDefaultInstance(),
                    BattleItems.STEEL_INGOT.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.COPPER_INGOT.getDefaultInstance(),
                    BattleItems.COPPER_NUGGET.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.DIAMOND.getDefaultInstance(),
                    BattleItems.DIAMOND_SHARD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.NETHERITE_INGOT.getDefaultInstance(),
                    BattleItems.NETHERITE_NUGGET.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(BattleItems.NETHERITE_NUGGET.get().getDefaultInstance(),
                    BattleItems.ENDER_CRYSTAL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(BattleItems.ENDER_CRYSTAL.get().getDefaultInstance(),
                    BattleItems.ENDERIUM_INGOT.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(BattleItems.ENDERIUM_INGOT.get().getDefaultInstance(),
                    BattleItems.ENDERIUM_NUGGET.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT){
            event.getEntries().putAfter(Items.IRON_SWORD.getDefaultInstance(),
                    BattleItems.STEEL_SWORD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.NETHERITE_SWORD.getDefaultInstance(),
                    BattleItems.ENDERIUM_SWORD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.IRON_AXE.getDefaultInstance(),
                    BattleItems.STEEL_AXE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.NETHERITE_AXE.getDefaultInstance(),
                    BattleItems.ENDERIUM_AXE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.getEntries().putAfter(Items.IRON_HOE.getDefaultInstance(),
                    BattleItems.STEEL_SHOVEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(BattleItems.STEEL_SHOVEL.get().getDefaultInstance(),
                    BattleItems.STEEL_PICKAXE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(BattleItems.STEEL_PICKAXE.get().getDefaultInstance(),
                    BattleItems.STEEL_AXE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(BattleItems.STEEL_AXE.get().getDefaultInstance(),
                    BattleItems.STEEL_HOE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.NETHERITE_HOE.getDefaultInstance(),
                    BattleItems.ENDERIUM_SHOVEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(BattleItems.ENDERIUM_SHOVEL.get().getDefaultInstance(),
                    BattleItems.ENDERIUM_PICKAXE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(BattleItems.ENDERIUM_PICKAXE.get().getDefaultInstance(),
                    BattleItems.ENDERIUM_AXE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(BattleItems.ENDERIUM_AXE.get().getDefaultInstance(),
                    BattleItems.ENDERIUM_HOE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    public static void register(IEventBus eventBus){ CREATIVE_MODE_TABS.register(eventBus); }
}
