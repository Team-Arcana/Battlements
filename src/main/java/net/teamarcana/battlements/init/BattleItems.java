package net.teamarcana.battlements.init;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.item.BaseWeaponItem;

public class BattleItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Battlements.MOD_ID);

    public static final DeferredItem<Item> CREATIVE_ICON = ITEMS.registerSimpleItem("battlements_combat_icon", new Item.Properties().stacksTo(1));

    // NEW ITEMS
    public static final DeferredItem<Item> HANDLE = ITEMS.registerSimpleItem("handle", new Item.Properties());
    public static final DeferredItem<Item> POLE = ITEMS.registerSimpleItem("pole", new Item.Properties());
    public static final DeferredItem<Item> ROCK = ITEMS.registerSimpleItem("rock", new Item.Properties());
    public static final DeferredItem<Item> COPPER_NUGGET = ITEMS.registerSimpleItem("copper_nugget", new Item.Properties());
    public static final DeferredItem<Item> DIAMOND_SHARD = ITEMS.registerSimpleItem("diamond_shard", new Item.Properties());
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerSimpleItem("steel_ingot", new Item.Properties());
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.registerSimpleItem("steel_nugget", new Item.Properties());
    public static final DeferredItem<Item> NETHERITE_NUGGET = ITEMS.registerSimpleItem("netherite_nugget", new Item.Properties());
    public static final DeferredItem<Item> ENDER_CRYSTAL = ITEMS.registerSimpleItem("ender_crystal", new Item.Properties());
    public static final DeferredItem<Item> ENDERIUM_INGOT = ITEMS.registerSimpleItem("enderium_ingot", new Item.Properties());
    public static final DeferredItem<Item> ENDERIUM_NUGGET = ITEMS.registerSimpleItem("enderium_nugget", new Item.Properties());

    // the blocks [because I apparently have to do this now]
    public static final DeferredItem<BlockItem> STEEL_BLOCK = ITEMS.registerSimpleBlockItem(BattleBlocks.STEEL_BLOCK);
    public static final DeferredItem<BlockItem> ENDERIUM_BLOCK = ITEMS.registerSimpleBlockItem(BattleBlocks.ENDERIUM_BLOCK);
    public static final DeferredItem<BlockItem> ENDER_CRYSTAL_BLOCK = ITEMS.registerSimpleBlockItem(BattleBlocks.ENDER_CRYSTAL_BLOCk);

    // new Base Tools and Weapons
    public static final DeferredItem<Item> STEEL_SWORD = ITEMS.register(
            "steel_sword", ()->  new SwordItem(BattleTiers.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(BattleTiers.STEEL, 3, -2.4F)))
    );
    public static final DeferredItem<Item> STEEL_SHOVEL = ITEMS.register(
            "steel_shovel", ()-> new ShovelItem(BattleTiers.STEEL, new Item.Properties().attributes(ShovelItem.createAttributes(BattleTiers.STEEL, 1F, -3.0F)))
    );
    public static final DeferredItem<Item> STEEL_PICKAXE = ITEMS.register(
            "steel_pickaxe", ()->  new PickaxeItem(BattleTiers.STEEL, new Item.Properties().attributes(PickaxeItem.createAttributes(BattleTiers.STEEL, 0F, -2.8F)))
    );
    public static final DeferredItem<Item> STEEL_AXE = ITEMS.register(
            "steel_axe", ()->  new AxeItem(BattleTiers.STEEL, new Item.Properties().attributes(AxeItem.createAttributes(BattleTiers.STEEL, 5.0F, -3.0F)))
    );
    public static final DeferredItem<Item> STEEL_HOE = ITEMS.register(
            "steel_hoe", ()->  new HoeItem(BattleTiers.STEEL, new Item.Properties().attributes(HoeItem.createAttributes(BattleTiers.STEEL, -3.0F, 0.0F)))
    );
    public static final DeferredItem<Item> ENDERIUM_SWORD = ITEMS.register(
            "enderium_sword",
            ()->new SwordItem(BattleTiers.ENDERIUM, new Item.Properties().attributes(SwordItem.createAttributes(BattleTiers.ENDERIUM, 3, -2.4F)))
    );
    public static final DeferredItem<Item> ENDERIUM_SHOVEL = ITEMS.register(
            "enderium_shovel",
            ()->new ShovelItem(BattleTiers.ENDERIUM, new Item.Properties().attributes(ShovelItem.createAttributes(BattleTiers.ENDERIUM, 1.5F, -3.0F)))
    );
    public static final DeferredItem<Item> ENDERIUM_PICKAXE = ITEMS.register(
            "enderium_pickaxe",
            ()->new PickaxeItem(BattleTiers.ENDERIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(BattleTiers.ENDERIUM, 1.0F, -2.8F)))
    );
    public static final DeferredItem<Item> ENDERIUM_AXE = ITEMS.register(
            "enderium_axe",
            ()-> new AxeItem(BattleTiers.ENDERIUM, new Item.Properties().attributes(AxeItem.createAttributes(BattleTiers.ENDERIUM, 5.0F, -3.0F)))
    );
    public static final DeferredItem<Item> ENDERIUM_HOE = ITEMS.register(
            "enderium_hoe",
            ()-> new HoeItem(BattleTiers.ENDERIUM, new Item.Properties().attributes(HoeItem.createAttributes(BattleTiers.ENDERIUM, -4.0F, 0.0F)))
    );

    // WEAPON TYPES
    public static final DeferredItem<BaseWeaponItem> WOODEN_DAGGER = ITEMS.register(
            "wooden_dagger", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.DAGGER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_LONGSWORD = ITEMS.register(
            "wooden_longsword", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.LONGSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_GREATSWORD = ITEMS.register(
            "wooden_greatsword", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.GREATSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_KATANA = ITEMS.register(
            "wooden_katana", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.KATANA, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_RAPIER = ITEMS.register(
            "wooden_rapier", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.RAPIER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_SABER = ITEMS.register(
            "wooden_saber", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.SABER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_CUTLASS = ITEMS.register(
            "wooden_cutlass", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.CUTLASS, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_SICKLE = ITEMS.register(
            "wooden_sickle", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.SICKLE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_CLAW = ITEMS.register(
            "wooden_claw", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.CLAW, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_CLUB = ITEMS.register(
            "wooden_club", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.CLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_GREATCLUB = ITEMS.register(
            "wooden_greatclub", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.GREATCLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_HAMMER = ITEMS.register(
            "wooden_hammer", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.HAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_WARHAMMER = ITEMS.register(
            "wooden_warhammer", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.WARHAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_MAUL = ITEMS.register(
            "wooden_maul", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.MAUL, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_ANCHOR = ITEMS.register(
            "wooden_anchor", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.ANCHOR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_WARPICK = ITEMS.register(
            "wooden_warpick", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.WARPICK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_BATTLEAXE = ITEMS.register(
            "wooden_battleaxe", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.BATTLEAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_GREATAXE = ITEMS.register(
            "wooden_greataxe", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.GREATAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_QUARTERSTAFF = ITEMS.register(
            "wooden_quarterstaff", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.QUARTERSTAFF, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_SPEAR = ITEMS.register(
            "wooden_spear", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.SPEAR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_PIKE = ITEMS.register(
            "wooden_pike", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.PIKE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_GLAIVE = ITEMS.register(
            "wooden_glaive", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.GLAIVE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_HALBERD = ITEMS.register(
            "wooden_halberd", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.HALBERD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_PITCHFORK = ITEMS.register(
            "wooden_pitchfork", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.PITCHFORK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_SCYTHE = ITEMS.register(
            "wooden_scythe", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.SCYTHE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_JAVELIN = ITEMS.register(
            "wooden_javelin", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.JAVELIN, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_BOOMERANG = ITEMS.register(
            "wooden_boomerang", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> WOODEN_KUNAI = ITEMS.register(
            "wooden_kunai", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.KUNAI, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> WOODEN_TOMAHAWK = ITEMS.register(
            "wooden_tomahawk", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.TOMAHAWK, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> WOODEN_THROWING_KNIFE = ITEMS.register(
            "wooden_throwing_knife", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.THROWING_KNIFE, new Item.Properties().durability(-1).stacksTo(64)));

    public static final DeferredItem<BaseWeaponItem> STONE_DAGGER = ITEMS.register(
            "stone_dagger", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.DAGGER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_LONGSWORD = ITEMS.register(
            "stone_longsword", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.LONGSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_GREATSWORD = ITEMS.register(
            "stone_greatsword", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.GREATSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_KATANA = ITEMS.register(
            "stone_katana", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.KATANA, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_RAPIER = ITEMS.register(
            "stone_rapier", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.RAPIER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_SABER = ITEMS.register(
            "stone_saber", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.SABER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_CUTLASS = ITEMS.register(
            "stone_cutlass", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.CUTLASS, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_SICKLE = ITEMS.register(
            "stone_sickle", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.SICKLE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_CLAW = ITEMS.register(
            "stone_claw", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.CLAW, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_CLUB = ITEMS.register(
            "stone_club", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.CLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_GREATCLUB = ITEMS.register(
            "stone_greatclub", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.GREATCLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_HAMMER = ITEMS.register(
            "stone_hammer", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.HAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_WARHAMMER = ITEMS.register(
            "stone_warhammer", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.WARHAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_MAUL = ITEMS.register(
            "stone_maul", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.MAUL, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_ANCHOR = ITEMS.register(
            "stone_anchor", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.ANCHOR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_WARPICK = ITEMS.register(
            "stone_warpick", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.WARPICK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_BATTLEAXE = ITEMS.register(
            "stone_battleaxe", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.BATTLEAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_GREATAXE = ITEMS.register(
            "stone_greataxe", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.GREATAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_QUARTERSTAFF = ITEMS.register(
            "stone_quarterstaff", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.QUARTERSTAFF, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_SPEAR = ITEMS.register(
            "stone_spear", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.SPEAR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_PIKE = ITEMS.register(
            "stone_pike", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.PIKE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_GLAIVE = ITEMS.register(
            "stone_glaive", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.GLAIVE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_HALBERD = ITEMS.register(
            "stone_halberd", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.HALBERD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_PITCHFORK = ITEMS.register(
            "stone_pitchfork", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.PITCHFORK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_SCYTHE = ITEMS.register(
            "stone_scythe", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.SCYTHE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_JAVELIN = ITEMS.register(
            "stone_javelin", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.JAVELIN, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_BOOMERANG = ITEMS.register(
            "stone_boomerang", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_KUNAI = ITEMS.register(
            "stone_kunai", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.KUNAI, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_TOMAHAWK = ITEMS.register(
            "stone_tomahawk", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.TOMAHAWK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STONE_THROWING_KNIFE = ITEMS.register(
            "stone_throwing_knife", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.THROWING_KNIFE, new Item.Properties()));

    public static final DeferredItem<BaseWeaponItem> GOLDEN_DAGGER = ITEMS.register(
            "golden_dagger", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.DAGGER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_LONGSWORD = ITEMS.register(
            "golden_longsword", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.LONGSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_GREATSWORD = ITEMS.register(
            "golden_greatsword", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.GREATSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_KATANA = ITEMS.register(
            "golden_katana", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.KATANA, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_RAPIER = ITEMS.register(
            "golden_rapier", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.RAPIER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_SABER = ITEMS.register(
            "golden_saber", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.SABER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_CUTLASS = ITEMS.register(
            "golden_cutlass", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.CUTLASS, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_SICKLE = ITEMS.register(
            "golden_sickle", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.SICKLE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_CLAW = ITEMS.register(
            "golden_claw", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.CLAW, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_CLUB = ITEMS.register(
            "golden_club", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.CLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_GREATCLUB = ITEMS.register(
            "golden_greatclub", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.GREATCLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_HAMMER = ITEMS.register(
            "golden_hammer", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.HAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_WARHAMMER = ITEMS.register(
            "golden_warhammer", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.WARHAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_MAUL = ITEMS.register(
            "golden_maul", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.MAUL, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_ANCHOR = ITEMS.register(
            "golden_anchor", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.ANCHOR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_WARPICK = ITEMS.register(
            "golden_warpick", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.WARPICK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_BATTLEAXE = ITEMS.register(
            "golden_battleaxe", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.BATTLEAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_GREATAXE = ITEMS.register(
            "golden_greataxe", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.GREATAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_QUARTERSTAFF = ITEMS.register(
            "golden_quarterstaff", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.QUARTERSTAFF, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_SPEAR = ITEMS.register(
            "golden_spear", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.SPEAR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_PIKE = ITEMS.register(
            "golden_pike", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.PIKE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_GLAIVE = ITEMS.register(
            "golden_glaive", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.GLAIVE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_HALBERD = ITEMS.register(
            "golden_halberd", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.HALBERD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_PITCHFORK = ITEMS.register(
            "golden_pitchfork", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.PITCHFORK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_SCYTHE = ITEMS.register(
            "golden_scythe", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.SCYTHE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_JAVELIN = ITEMS.register(
            "golden_javelin", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.JAVELIN, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_BOOMERANG = ITEMS.register(
            "golden_boomerang", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_KUNAI = ITEMS.register(
            "golden_kunai", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.KUNAI, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_TOMAHAWK = ITEMS.register(
            "golden_tomahawk", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.TOMAHAWK, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> GOLDEN_THROWING_KNIFE = ITEMS.register(
            "golden_throwing_knife", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.THROWING_KNIFE, new Item.Properties().durability(-1).stacksTo(64)));

    public static final DeferredItem<BaseWeaponItem> IRON_DAGGER = ITEMS.register(
            "iron_dagger", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.DAGGER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_LONGSWORD = ITEMS.register(
            "iron_longsword", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.LONGSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_GREATSWORD = ITEMS.register(
            "iron_greatsword", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.GREATSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_KATANA = ITEMS.register(
            "iron_katana", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.KATANA, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_RAPIER = ITEMS.register(
            "iron_rapier", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.RAPIER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_SABER = ITEMS.register(
            "iron_saber", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.SABER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_CUTLASS = ITEMS.register(
            "iron_cutlass", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.CUTLASS, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_SICKLE = ITEMS.register(
            "iron_sickle", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.SICKLE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_CLAW = ITEMS.register(
            "iron_claw", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.CLAW, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_CLUB = ITEMS.register(
            "iron_club", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.CLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_GREATCLUB = ITEMS.register(
            "iron_greatclub", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.GREATCLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_HAMMER = ITEMS.register(
            "iron_hammer", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.HAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_WARHAMMER = ITEMS.register(
            "iron_warhammer", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.WARHAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_MAUL = ITEMS.register(
            "iron_maul", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.MAUL, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_ANCHOR = ITEMS.register(
            "iron_anchor", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.ANCHOR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_WARPICK = ITEMS.register(
            "iron_warpick", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.WARPICK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_BATTLEAXE = ITEMS.register(
            "iron_battleaxe", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.BATTLEAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_GREATAXE = ITEMS.register(
            "iron_greataxe", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.GREATAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_QUARTERSTAFF = ITEMS.register(
            "iron_quarterstaff", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.QUARTERSTAFF, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_SPEAR = ITEMS.register(
            "iron_spear", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.SPEAR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_PIKE = ITEMS.register(
            "iron_pike", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.PIKE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_GLAIVE = ITEMS.register(
            "iron_glaive", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.GLAIVE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_HALBERD = ITEMS.register(
            "iron_halberd", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.HALBERD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_PITCHFORK = ITEMS.register(
            "iron_pitchfork", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.PITCHFORK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_SCYTHE = ITEMS.register(
            "iron_scythe", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.SCYTHE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_JAVELIN = ITEMS.register(
            "iron_javelin", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.JAVELIN, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_BOOMERANG = ITEMS.register(
            "iron_boomerang", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_KUNAI = ITEMS.register(
            "iron_kunai", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.KUNAI, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> IRON_TOMAHAWK = ITEMS.register(
            "iron_tomahawk", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.TOMAHAWK, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> IRON_THROWING_KNIFE = ITEMS.register(
            "iron_throwing_knife", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.THROWING_KNIFE, new Item.Properties().durability(-1).stacksTo(64)));

    public static final DeferredItem<BaseWeaponItem> STEEL_DAGGER = ITEMS.register(
            "steel_dagger", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.DAGGER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_LONGSWORD = ITEMS.register(
            "steel_longsword", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.LONGSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_GREATSWORD = ITEMS.register(
            "steel_greatsword", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.GREATSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_KATANA = ITEMS.register(
            "steel_katana", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.KATANA, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_RAPIER = ITEMS.register(
            "steel_rapier", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.RAPIER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_SABER = ITEMS.register(
            "steel_saber", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.SABER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_CUTLASS = ITEMS.register(
            "steel_cutlass", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.CUTLASS, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_SICKLE = ITEMS.register(
            "steel_sickle", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.SICKLE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_CLAW = ITEMS.register(
            "steel_claw", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.CLAW, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_CLUB = ITEMS.register(
            "steel_club", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.CLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_GREATCLUB = ITEMS.register(
            "steel_greatclub", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.GREATCLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_HAMMER = ITEMS.register(
            "steel_hammer", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.HAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_WARHAMMER = ITEMS.register(
            "steel_warhammer", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.WARHAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_MAUL = ITEMS.register(
            "steel_maul", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.MAUL, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_ANCHOR = ITEMS.register(
            "steel_anchor", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.ANCHOR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_WARPICK = ITEMS.register(
            "steel_warpick", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.WARPICK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_BATTLEAXE = ITEMS.register(
            "steel_battleaxe", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.BATTLEAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_GREATAXE = ITEMS.register(
            "steel_greataxe", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.GREATAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_QUARTERSTAFF = ITEMS.register(
            "steel_quarterstaff", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.QUARTERSTAFF, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_SPEAR = ITEMS.register(
            "steel_spear", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.SPEAR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_PIKE = ITEMS.register(
            "steel_pike", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.PIKE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_GLAIVE = ITEMS.register(
            "steel_glaive", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.GLAIVE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_HALBERD = ITEMS.register(
            "steel_halberd", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.HALBERD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_PITCHFORK = ITEMS.register(
            "steel_pitchfork", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.PITCHFORK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_SCYTHE = ITEMS.register(
            "steel_scythe", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.SCYTHE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_JAVELIN = ITEMS.register(
            "steel_javelin", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.JAVELIN, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_BOOMERANG = ITEMS.register(
            "steel_boomerang", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> STEEL_KUNAI = ITEMS.register(
            "steel_kunai", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.KUNAI, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> STEEL_TOMAHAWK = ITEMS.register(
            "steel_tomahawk", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.TOMAHAWK, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> STEEL_THROWING_KNIFE = ITEMS.register(
            "steel_throwing_knife", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.THROWING_KNIFE, new Item.Properties().durability(-1).stacksTo(64)));

    public static final DeferredItem<BaseWeaponItem> DIAMOND_DAGGER = ITEMS.register(
            "diamond_dagger", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.DAGGER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_LONGSWORD = ITEMS.register(
            "diamond_longsword", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.LONGSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_GREATSWORD = ITEMS.register(
            "diamond_greatsword", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.GREATSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_KATANA = ITEMS.register(
            "diamond_katana", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.KATANA, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_RAPIER = ITEMS.register(
            "diamond_rapier", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.RAPIER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_SABER = ITEMS.register(
            "diamond_saber", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.SABER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_CUTLASS = ITEMS.register(
            "diamond_cutlass", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.CUTLASS, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_SICKLE = ITEMS.register(
            "diamond_sickle", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.SICKLE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_CLAW = ITEMS.register(
            "diamond_claw", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.CLAW, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_CLUB = ITEMS.register(
            "diamond_club", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.CLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_GREATCLUB = ITEMS.register(
            "diamond_greatclub", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.GREATCLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_HAMMER = ITEMS.register(
            "diamond_hammer", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.HAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_WARHAMMER = ITEMS.register(
            "diamond_warhammer", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.WARHAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_MAUL = ITEMS.register(
            "diamond_maul", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.MAUL, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_ANCHOR = ITEMS.register(
            "diamond_anchor", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.ANCHOR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_WARPICK = ITEMS.register(
            "diamond_warpick", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.WARPICK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_BATTLEAXE = ITEMS.register(
            "diamond_battleaxe", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.BATTLEAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_GREATAXE = ITEMS.register(
            "diamond_greataxe", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.GREATAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_QUARTERSTAFF = ITEMS.register(
            "diamond_quarterstaff", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.QUARTERSTAFF, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_SPEAR = ITEMS.register(
            "diamond_spear", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.SPEAR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_PIKE = ITEMS.register(
            "diamond_pike", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.PIKE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_GLAIVE = ITEMS.register(
            "diamond_glaive", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.GLAIVE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_HALBERD = ITEMS.register(
            "diamond_halberd", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.HALBERD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_PITCHFORK = ITEMS.register(
            "diamond_pitchfork", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.PITCHFORK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_SCYTHE = ITEMS.register(
            "diamond_scythe", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.SCYTHE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_JAVELIN = ITEMS.register(
            "diamond_javelin", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.JAVELIN, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_BOOMERANG = ITEMS.register(
            "diamond_boomerang", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_KUNAI = ITEMS.register(
            "diamond_kunai", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.KUNAI, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_TOMAHAWK = ITEMS.register(
            "diamond_tomahawk", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.TOMAHAWK, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> DIAMOND_THROWING_KNIFE = ITEMS.register(
            "diamond_throwing_knife", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.THROWING_KNIFE, new Item.Properties().durability(-1).stacksTo(64)));

    public static final DeferredItem<BaseWeaponItem> NETHERITE_DAGGER = ITEMS.register(
            "netherite_dagger", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.DAGGER, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_LONGSWORD = ITEMS.register(
            "netherite_longsword", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.LONGSWORD, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_GREATSWORD = ITEMS.register(
            "netherite_greatsword", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.GREATSWORD, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_KATANA = ITEMS.register(
            "netherite_katana", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.KATANA, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_RAPIER = ITEMS.register(
            "netherite_rapier", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.RAPIER, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_SABER = ITEMS.register(
            "netherite_saber", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.SABER, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_CUTLASS = ITEMS.register(
            "netherite_cutlass", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.CUTLASS, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_SICKLE = ITEMS.register(
            "netherite_sickle", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.SICKLE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_CLAW = ITEMS.register(
            "netherite_claw", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.CLAW, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_CLUB = ITEMS.register(
            "netherite_club", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.CLUB, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_GREATCLUB = ITEMS.register(
            "netherite_greatclub", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.GREATCLUB, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_HAMMER = ITEMS.register(
            "netherite_hammer", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.HAMMER, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_WARHAMMER = ITEMS.register(
            "netherite_warhammer", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.WARHAMMER, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_MAUL = ITEMS.register(
            "netherite_maul", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.MAUL, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_ANCHOR = ITEMS.register(
            "netherite_anchor", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.ANCHOR, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_WARPICK = ITEMS.register(
            "netherite_warpick", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.WARPICK, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_BATTLEAXE = ITEMS.register(
            "netherite_battleaxe", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.BATTLEAXE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_GREATAXE = ITEMS.register(
            "netherite_greataxe", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.GREATAXE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_QUARTERSTAFF = ITEMS.register(
            "netherite_quarterstaff", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.QUARTERSTAFF, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_SPEAR = ITEMS.register(
            "netherite_spear", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.SPEAR, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_PIKE = ITEMS.register(
            "netherite_pike", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.PIKE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_GLAIVE = ITEMS.register(
            "netherite_glaive", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.GLAIVE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_HALBERD = ITEMS.register(
            "netherite_halberd", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.HALBERD, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_PITCHFORK = ITEMS.register(
            "netherite_pitchfork", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.PITCHFORK, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_SCYTHE = ITEMS.register(
            "netherite_scythe", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.SCYTHE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_JAVELIN = ITEMS.register(
            "netherite_javelin", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.JAVELIN, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_BOOMERANG = ITEMS.register(
            "netherite_boomerang", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.BOOMERANG, new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_KUNAI = ITEMS.register(
            "netherite_kunai", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.KUNAI, new Item.Properties().fireResistant().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_TOMAHAWK = ITEMS.register(
            "netherite_tomahawk", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.TOMAHAWK, new Item.Properties().fireResistant().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> NETHERITE_THROWING_KNIFE = ITEMS.register(
            "netherite_throwing_knife", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.THROWING_KNIFE, new Item.Properties().fireResistant().durability(-1).stacksTo(64)));

    public static final DeferredItem<BaseWeaponItem> ENDERIUM_DAGGER = ITEMS.register(
            "enderium_dagger", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.DAGGER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_LONGSWORD = ITEMS.register(
            "enderium_longsword", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.LONGSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_GREATSWORD = ITEMS.register(
            "enderium_greatsword", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.GREATSWORD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_KATANA = ITEMS.register(
            "enderium_katana", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.KATANA, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_RAPIER = ITEMS.register(
            "enderium_rapier", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.RAPIER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_SABER = ITEMS.register(
            "enderium_saber", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.SABER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_CUTLASS = ITEMS.register(
            "enderium_cutlass", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.CUTLASS, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_SICKLE = ITEMS.register(
            "enderium_sickle", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.SICKLE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_CLAW = ITEMS.register(
            "enderium_claw", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.CLAW, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_CLUB = ITEMS.register(
            "enderium_club", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.CLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_GREATCLUB = ITEMS.register(
            "enderium_greatclub", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.GREATCLUB, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_HAMMER = ITEMS.register(
            "enderium_hammer", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.HAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_WARHAMMER = ITEMS.register(
            "enderium_warhammer", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.WARHAMMER, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_MAUL = ITEMS.register(
            "enderium_maul", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.MAUL, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_ANCHOR = ITEMS.register(
            "enderium_anchor", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.ANCHOR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_WARPICK = ITEMS.register(
            "enderium_warpick", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.WARPICK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_BATTLEAXE = ITEMS.register(
            "enderium_battleaxe", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.BATTLEAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_GREATAXE = ITEMS.register(
            "enderium_greataxe", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.GREATAXE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_QUARTERSTAFF = ITEMS.register(
            "enderium_quarterstaff", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.QUARTERSTAFF, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_SPEAR = ITEMS.register(
            "enderium_spear", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.SPEAR, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_PIKE = ITEMS.register(
            "enderium_pike", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.PIKE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_GLAIVE = ITEMS.register(
            "enderium_glaive", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.GLAIVE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_HALBERD = ITEMS.register(
            "enderium_halberd", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.HALBERD, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_PITCHFORK = ITEMS.register(
            "enderium_pitchfork", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.PITCHFORK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_SCYTHE = ITEMS.register(
            "enderium_scythe", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.SCYTHE, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_JAVELIN = ITEMS.register(
            "enderium_javelin", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.JAVELIN, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_BOOMERANG = ITEMS.register(
            "enderium_boomerang", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_KUNAI = ITEMS.register(
            "enderium_kunai", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.KUNAI, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_TOMAHAWK = ITEMS.register(
            "enderium_tomahawk", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.TOMAHAWK, new Item.Properties().durability(-1).stacksTo(64)));
    public static final DeferredItem<BaseWeaponItem> ENDERIUM_THROWING_KNIFE = ITEMS.register(
            "enderium_throwing_knife", () -> new BaseWeaponItem(BattleTiers.ENDERIUM, BattleArchetypes.THROWING_KNIFE, new Item.Properties().durability(-1).stacksTo(64)));

    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }
}
