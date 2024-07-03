package net.teamarcana.battlements.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CommunityTags {
    public static final TagKey<Item> INGOTS_STEEL = itemTag("ingots/steel");
    public static final TagKey<Item> NUGGETS_STEEL = itemTag("nuggets/steel");
    public static final TagKey<Item> INGOTS_ENDERIUM = itemTag("ingots/enderium");
    public static final TagKey<Item> NUGGETS_ENDERIUM = itemTag("nuggets/enderium");
    public static final TagKey<Item> NUGGETS_NETHERITE = itemTag("nuggets/netherite");
    public static final TagKey<Item> NUGGETS_DIAMOND = itemTag("nuggets/enderium");

    public static final TagKey<Item> ZOMBIE_SPAWN_WEAPONS = itemTag("tools/zombie_spawn_weapons");
    public static final TagKey<Item> PIGLIN_SPAWN_WEAPONS = itemTag("tools/piglin_spawn_weapons");
    public static final TagKey<Item> SKELETON_SPAWN_WEAPONS = itemTag("tools/piglin_spawn_weapons");

    public static final TagKey<Item> WEAPONS_DAGGER = itemTag("weapons/daggers");
    public static final TagKey<Item> WEAPONS_LONGSWORD = itemTag("weapons/longswords");
    public static final TagKey<Item> WEAPONS_GREATSWORD = itemTag("weapons/greatswords");
    public static final TagKey<Item> WEAPONS_KATANA = itemTag("weapons/katanas");
    public static final TagKey<Item> WEAPONS_RAPIER = itemTag("weapons/rapiers");
    public static final TagKey<Item> WEAPONS_SABER = itemTag("weapons/sabers");
    public static final TagKey<Item> WEAPONS_CUTLASS = itemTag("weapons/cutlasses");
    public static final TagKey<Item> WEAPONS_SICKLE = itemTag("weapons/sickles");
    public static final TagKey<Item> WEAPONS_CLAW = itemTag("weapons/claws");
    public static final TagKey<Item> WEAPONS_CLUB = itemTag("weapons/clubs");
    public static final TagKey<Item> WEAPONS_GREATCLUB = itemTag("weapons/greatclubs");
    public static final TagKey<Item> WEAPONS_HAMMER = itemTag("weapons/hammers");
    public static final TagKey<Item> WEAPONS_WARHAMMER = itemTag("weapons/warhammers");
    public static final TagKey<Item> WEAPONS_MAUL = itemTag("weapons/mauls");
    public static final TagKey<Item> WEAPONS_ANCHOR = itemTag("weapons/anchors");
    public static final TagKey<Item> WEAPONS_WARPICK = itemTag("weapons/warpicks");
    public static final TagKey<Item> WEAPONS_BATTLEAXE = itemTag("weapons/battleaxes");
    public static final TagKey<Item> WEAPONS_GREATAXE = itemTag("weapons/greataxes");
    public static final TagKey<Item> WEAPONS_HALBERD = itemTag("weapons/halberds");
    public static final TagKey<Item> WEAPONS_SPEAR = itemTag("weapons/spears");
    public static final TagKey<Item> WEAPONS_PIKE = itemTag("weapons/pikes");
    public static final TagKey<Item> WEAPONS_QUARTERSTAFF = itemTag("weapons/quarterstaves");
    public static final TagKey<Item> WEAPONS_PITCHFORK = itemTag("weapons/pitchforks");
    public static final TagKey<Item> WEAPONS_GLAIVE = itemTag("weapons/glaives");
    public static final TagKey<Item> WEAPONS_SCYTHE = itemTag("weapons/scythes");
    public static final TagKey<Item> WEAPONS_JAVELIN = itemTag("weapons/javelins");
    public static final TagKey<Item> WEAPONS_BOOMERANG = itemTag("weapons/boomerangs");
    public static final TagKey<Item> WEAPONS_KUNAI = itemTag("weapons/kunais");
    public static final TagKey<Item> WEAPONS_THROWING_KNIFE = itemTag("weapons/throwing_knives");
    public static final TagKey<Item> WEAPONS_TOMAHAWK = itemTag("weapons/tomahawks");

    public static final TagKey<Item> ENCHANTABLE_BLUNT = itemTag("enchantable/blunt_weapon");
    public static final TagKey<Item> KNOCKBACK_ENCHANTABLE = itemTag("enchantable/knockback");
    public static final TagKey<Item> SWEEPING_ENCHANTABLE = itemTag("enchantable/sweeping");
    public static final TagKey<Item> LOOTING_ENCHANTABLE = itemTag("enchantable/looting");
    public static final TagKey<Item> ENCHANTABLE_WEAPON = itemTag("enchantable/weapon");

    // tags for archetypes
    public static final TagKey<Item> STUNNING = itemTag("weapon_stat/stunning");
    public static final TagKey<Item> BLEEDING = itemTag("weapon_stat/bleeding");
    public static final TagKey<Item> SWEEPING = itemTag("weapon_stat/sweeping");
    public static final TagKey<Item> BACKSTABBING = itemTag("weapon_stat/backstabbing");

    private static TagKey<Item> itemTag(String path){
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
    }
    private static TagKey<Block> blockTag(String path){
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
