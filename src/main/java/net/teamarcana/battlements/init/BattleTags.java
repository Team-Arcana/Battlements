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
}
