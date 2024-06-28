package net.teamarcana.battlements.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.trait.Trait;

public class BattleTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_STEEL_TOOL = tag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = tag("incorrect_for_steel_tool");
        public static final TagKey<Block> NEEDS_ENDERIUM_TOOL = tag("needs_enderium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ENDERIUM_TOOL = tag("incorrect_for_enderium_tool");

        private static TagKey<Block> tag(String name){
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BLADED_MELEE = tag("bladed_melee_weapons");
        public static final TagKey<Item> BLUNT_MELEE = tag("blunt_melee_weapons");
        public static final TagKey<Item> BLADED_THROWING = tag("bladed_throwing_weapons");
        public static final TagKey<Item> BLUNT_THROWING = tag("blunt_throwing_weapons");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, name));
        }
    }
    public static class Traits {
        public static final TagKey<Trait> DAGGER = tag("daggers");
        public static final TagKey<Trait> LONGSWORD = tag("longswords");
        public static final TagKey<Trait> GREATSWORD = tag("greatswords");
        public static final TagKey<Trait> KATANA = tag("katanas");
        public static final TagKey<Trait> RAPIER = tag("rapiers");
        public static final TagKey<Trait> SABER = tag("sabers");
        public static final TagKey<Trait> CUTLASS = tag("cutlasses");
        public static final TagKey<Trait> SICKLE = tag("sickles");
        public static final TagKey<Trait> CLAW = tag("claws");
        public static final TagKey<Trait> CLUB = tag("clubs");
        public static final TagKey<Trait> GREATCLUB = tag("greatclubs");
        public static final TagKey<Trait> HAMMER = tag("hammers");
        public static final TagKey<Trait> WARHAMMER = tag("warhammers");
        public static final TagKey<Trait> MAUL = tag("mauls");
        public static final TagKey<Trait> ANCHOR = tag("anchors");
        public static final TagKey<Trait> WARPICK = tag("warpicks");
        public static final TagKey<Trait> BATTLEAXE = tag("battleaxes");
        public static final TagKey<Trait> GREATAXE = tag("greataxes");
        public static final TagKey<Trait> HALBERD = tag("halberds");
        public static final TagKey<Trait> SPEAR = tag("spears");
        public static final TagKey<Trait> PIKE = tag("pikes");
        public static final TagKey<Trait> QUARTERSTAFF = tag("quarterstaves");
        public static final TagKey<Trait> PITCHFORK = tag("pitchforks");
        public static final TagKey<Trait> GLAIVE = tag("glaives");
        public static final TagKey<Trait> SCYTHE = tag("scythes");
        public static final TagKey<Trait> JAVELIN = tag("javelins");
        public static final TagKey<Trait> BOOMERANG = tag("boomerangs");
        public static final TagKey<Trait> KUNAI = tag("kunais");
        public static final TagKey<Trait> THROWING_KNIFE = tag("throwing_knives");
        public static final TagKey<Trait> TOMAHAWK = tag("tomahawks");

        private static TagKey<Trait> tag(String name) {
            return TagKey.create(Battlements.TRAIT_REGISTRY_KEY, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, name));
        }
    }
}
