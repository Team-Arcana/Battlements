package net.teamarcana.battlements.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.weapon_trait.Trait;

public class BattleTags {
    public static class Blocks{
        //public static final TagKey<Block> LEAD_ORES = tag("lead_ores");
        public static final TagKey<Block> NEEDS_STEEL_TOOL = tag("needs_steel_tool");
        public static final TagKey<Block> NEEDS_ENDERIUM_TOOL = tag("needs_enderium_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> DAGGERS = tag("daggers");
        public static final TagKey<Item> LONGSWORDS = tag("longswords");
        public static final TagKey<Item> GREATSWORDS = tag("greatswords");
        public static final TagKey<Item> KATANAS = tag("katanas");
        public static final TagKey<Item> RAPIERS = tag("rapiers");
        public static final TagKey<Item> SABERS = tag("sabers");
        public static final TagKey<Item> CUTLASSES = tag("cutlasses");
        public static final TagKey<Item> SICKLES = tag("sickles");
        public static final TagKey<Item> CLAWS = tag("claws");
        public static final TagKey<Item> CLUBS = tag("clubs");
        public static final TagKey<Item> GREATCLUBS = tag("greatclubs");
        public static final TagKey<Item> HAMMERS = tag("hammers");
        public static final TagKey<Item> WARHAMMERS = tag("warhammers");
        public static final TagKey<Item> MAULS = tag("mauls");
        public static final TagKey<Item> MACES = tag("maces");
        public static final TagKey<Item> ANCHORS = tag("anchors");
        public static final TagKey<Item> WARPICKS = tag("warpicks");
        public static final TagKey<Item> BATTLEAXES = tag("battleaxes");
        public static final TagKey<Item> GREATAXES = tag("greataxes");
        public static final TagKey<Item> HALBERDS = tag("halberds");
        public static final TagKey<Item> QUARTERSTAVES = tag("quarterstaves");
        public static final TagKey<Item> SPEARS = tag("spears");
        public static final TagKey<Item> PIKES = tag("pikes");
        public static final TagKey<Item> JAVELINS = tag("javelins");
        public static final TagKey<Item> GLAIVES = tag("glaives");
        public static final TagKey<Item> SCYTHES = tag("scythes");
        public static final TagKey<Item> BOOMERANGS = tag("boomerangs");
        public static final TagKey<Item> PITCHFORKS = tag("pitchforks");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, name));
        }
    }

    public static class Traits{
        public static final TagKey<Trait> DAGGER = tag("dagger");
        public static final TagKey<Trait> LONGSWORD = tag("longsword");
        public static final TagKey<Trait> GREATSWORD = tag("greatsword");
        public static final TagKey<Trait> KATANA = tag("katana");
        public static final TagKey<Trait> RAPIER = tag("rapier");
        public static final TagKey<Trait> SABER = tag("saber");
        public static final TagKey<Trait> CUTLASS = tag("cutlass");
        public static final TagKey<Trait> SICKLE = tag("sickle");
        public static final TagKey<Trait> CLAW = tag("claw");
        public static final TagKey<Trait> CLUB = tag("club");
        public static final TagKey<Trait> GREATCLUB = tag("greatclub");
        public static final TagKey<Trait> HAMMER = tag("hammer");
        public static final TagKey<Trait> WARHAMMER = tag("warhammer");
        public static final TagKey<Trait> MAUL = tag("maul");
        public static final TagKey<Trait> MACE = tag("mace");
        public static final TagKey<Trait> ANCHOR = tag("anchor");
        public static final TagKey<Trait> WARPICK = tag("warpick");
        public static final TagKey<Trait> BATTLEAXE = tag("battleaxe");
        public static final TagKey<Trait> GREATAXE = tag("greataxe");
        public static final TagKey<Trait> SPEAR = tag("spear");
        public static final TagKey<Trait> PIKE = tag("pike");
        public static final TagKey<Trait> QUARTERSTAFF = tag("quarterstaff");
        public static final TagKey<Trait> GLAIVE = tag("glaive");
        public static final TagKey<Trait> SCYTHE = tag("scythe");
        public static final TagKey<Trait> PITCHFORK = tag("pitchfork");
        public static final TagKey<Trait> HALBERD = tag("halberd");
        public static final TagKey<Trait> JAVELIN = tag("javelin");
        public static final TagKey<Trait> BOOMERANG = tag("boomerang");


        public static TagKey<Trait> tag(ResourceLocation location) { return TagKey.create(BattleTraits.REGISTRY_KEY, location); }
        public static TagKey<Trait> tag(String namespace, String path) { return tag(ResourceLocation.fromNamespaceAndPath(namespace, path)); }
        public static TagKey<Trait> tag(String path) { return tag(Battlements.MOD_ID, path); }
    }
}
