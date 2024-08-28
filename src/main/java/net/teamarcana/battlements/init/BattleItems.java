package net.teamarcana.battlements.init;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.item.*;

public class BattleItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Battlements.MOD_ID);

    // NEW ITEMS
    public static final DeferredItem<Item> DIAMOND_SHARD = ITEMS.registerSimpleItem("diamond_shard", new Item.Properties());
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerSimpleItem("steel_ingot", new Item.Properties());
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.registerSimpleItem("steel_nugget", new Item.Properties());
    public static final DeferredItem<Item> NETHERITE_NUGGET = ITEMS.registerSimpleItem("netherite_nugget", new Item.Properties());

    // the blocks [because I apparently have to do this now]
    public static final DeferredItem<BlockItem> STEEL_BLOCK = ITEMS.registerSimpleBlockItem(BattleBlocks.STEEL_BLOCK);

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

    // MELEE WEAPONS
    public static final DeferredItem<BaseWeaponItem> STONE_BATTLEAXE = ITEMS.register(
            "stone_battleaxe", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.BATTLEAXE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> GOLDEN_BATTLEAXE = ITEMS.register(
            "golden_battleaxe", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.BATTLEAXE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_BATTLEAXE = ITEMS.register(
            "iron_battleaxe", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.BATTLEAXE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_BATTLEAXE = ITEMS.register(
            "steel_battleaxe", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.BATTLEAXE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_BATTLEAXE = ITEMS.register(
            "diamond_battleaxe", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.BATTLEAXE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_BATTLEAXE = ITEMS.register(
            "netherite_battleaxe", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.BATTLEAXE, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> GOLDEN_ANCHOR = ITEMS.register(
            "golden_anchor", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.ANCHOR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_ANCHOR = ITEMS.register(
            "iron_anchor", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.ANCHOR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_ANCHOR = ITEMS.register(
            "steel_anchor", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.ANCHOR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_ANCHOR = ITEMS.register(
            "diamond_anchor", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.ANCHOR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_ANCHOR = ITEMS.register(
            "netherite_anchor", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.ANCHOR, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> GOLDEN_HAMMER = ITEMS.register(
            "golden_hammer", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.HAMMER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_HAMMER = ITEMS.register(
            "iron_hammer", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.HAMMER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_HAMMER = ITEMS.register(
            "steel_hammer", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.HAMMER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_HAMMER = ITEMS.register(
            "diamond_hammer", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.HAMMER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_HAMMER = ITEMS.register(
            "netherite_hammer", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.HAMMER, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> WOODEN_CLUB = ITEMS.register(
            "wooden_club", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.CLUB, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> BONE_CLUB = ITEMS.register(
            "bone_club", () -> new BaseWeaponItem(BattleTiers.BONE, BattleArchetypes.CLUB, new Item.Properties())
    );

    public static final DeferredItem<ParryingWeaponItem> GOLDEN_KATANA = ITEMS.register(
            "golden_katana", () -> new ParryingWeaponItem(Tiers.GOLD, BattleArchetypes.KATANA, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> IRON_KATANA = ITEMS.register(
            "iron_katana", () -> new ParryingWeaponItem(Tiers.IRON, BattleArchetypes.KATANA, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> STEEL_KATANA = ITEMS.register(
            "steel_katana", () -> new ParryingWeaponItem(BattleTiers.STEEL, BattleArchetypes.KATANA, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> DIAMOND_KATANA = ITEMS.register(
            "diamond_katana", () -> new ParryingWeaponItem(Tiers.DIAMOND, BattleArchetypes.KATANA, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> NETHERITE_KATANA = ITEMS.register(
            "netherite_katana", () -> new ParryingWeaponItem(Tiers.NETHERITE, BattleArchetypes.KATANA, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> GOLDEN_RAPIER = ITEMS.register(
            "golden_rapier", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.RAPIER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_RAPIER = ITEMS.register(
            "iron_rapier", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.RAPIER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_RAPIER = ITEMS.register(
            "steel_rapier", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.RAPIER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_RAPIER = ITEMS.register(
            "diamond_rapier", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.RAPIER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_RAPIER = ITEMS.register(
            "netherite_rapier", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.RAPIER, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> WOODEN_CUTLASS = ITEMS.register(
            "wooden_cutlass", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.CUTLASS, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> GOLDEN_CUTLASS = ITEMS.register(
            "golden_cutlass", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.CUTLASS, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_CUTLASS = ITEMS.register(
            "iron_cutlass", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.CUTLASS, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_CUTLASS = ITEMS.register(
            "steel_cutlass", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.CUTLASS, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_CUTLASS = ITEMS.register(
            "diamond_cutlass", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.CUTLASS, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_CUTLASS = ITEMS.register(
            "netherite_cutlass", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.CUTLASS, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> FLINT_DAGGER = ITEMS.register(
            "flint_dagger", () -> new BaseWeaponItem(BattleTiers.FLINT, BattleArchetypes.DAGGER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> BONE_DAGGER = ITEMS.register(
            "bone_dagger", () -> new BaseWeaponItem(BattleTiers.BONE, BattleArchetypes.DAGGER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> GOLDEN_DAGGER = ITEMS.register(
            "golden_dagger", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.DAGGER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_DAGGER = ITEMS.register(
            "iron_dagger", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.DAGGER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_DAGGER = ITEMS.register(
            "steel_dagger", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.DAGGER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_DAGGER = ITEMS.register(
            "diamond_dagger", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.DAGGER, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_DAGGER = ITEMS.register(
            "netherite_dagger", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.DAGGER, new Item.Properties())
    );


    public static final DeferredItem<BaseWeaponItem> STONE_GREATSWORD = ITEMS.register(
            "stone_greatsword", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.GREATSWORD, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> GOLDEN_GREATSWORD = ITEMS.register(
            "golden_greatsword", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.GREATSWORD, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_GREATSWORD = ITEMS.register(
            "iron_greatsword", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.GREATSWORD, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_GREATSWORD = ITEMS.register(
            "steel_greatsword", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.GREATSWORD, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_GREATSWORD = ITEMS.register(
            "diamond_greatsword", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.GREATSWORD, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_GREATSWORD = ITEMS.register(
            "netherite_greatsword", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.GREATSWORD, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> FLINT_CLAW = ITEMS.register(
            "flint_claw", () -> new BaseWeaponItem(BattleTiers.FLINT, BattleArchetypes.CLAW, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> GOLDEN_CLAW = ITEMS.register(
            "golden_claw", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.CLAW, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_CLAW = ITEMS.register(
            "iron_claw", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.CLAW, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_CLAW = ITEMS.register(
            "steel_claw", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.CLAW, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_CLAW = ITEMS.register(
            "diamond_claw", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.CLAW, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_CLAW = ITEMS.register(
            "netherite_claw", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.CLAW, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> GOLDEN_SICKLE = ITEMS.register(
            "golden_sickle", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.SICKLE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_SICKLE = ITEMS.register(
            "iron_sickle", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.SICKLE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_SICKLE = ITEMS.register(
            "steel_sickle", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.SICKLE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_SICKLE = ITEMS.register(
            "diamond_sickle", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.SICKLE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_SICKLE = ITEMS.register(
            "netherite_sickle", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.SICKLE, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> FLINT_SPEAR = ITEMS.register(
            "flint_spear", () -> new BaseWeaponItem(BattleTiers.FLINT, BattleArchetypes.SPEAR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> GOLDEN_SPEAR = ITEMS.register(
            "golden_spear", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.SPEAR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_SPEAR = ITEMS.register(
            "iron_spear", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.SPEAR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_SPEAR = ITEMS.register(
            "steel_spear", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.SPEAR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_SPEAR = ITEMS.register(
            "diamond_spear", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.SPEAR, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_SPEAR = ITEMS.register(
            "netherite_spear", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.SPEAR, new Item.Properties())
    );

    public static final DeferredItem<ParryingWeaponItem> WOODEN_QUARTERSTAFF = ITEMS.register(
            "wooden_quarterstaff", () -> new ParryingWeaponItem(Tiers.WOOD, BattleArchetypes.QUARTERSTAFF, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> GOLDEN_QUARTERSTAFF = ITEMS.register(
            "golden_quarterstaff", () -> new ParryingWeaponItem(Tiers.GOLD, BattleArchetypes.QUARTERSTAFF, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> IRON_QUARTERSTAFF = ITEMS.register(
            "iron_quarterstaff", () -> new ParryingWeaponItem(Tiers.IRON, BattleArchetypes.QUARTERSTAFF, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> STEEL_QUARTERSTAFF = ITEMS.register(
            "steel_quarterstaff", () -> new ParryingWeaponItem(BattleTiers.STEEL, BattleArchetypes.QUARTERSTAFF, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> DIAMOND_QUARTERSTAFF = ITEMS.register(
            "diamond_quarterstaff", () -> new ParryingWeaponItem(Tiers.DIAMOND, BattleArchetypes.QUARTERSTAFF, new Item.Properties())
    );
    public static final DeferredItem<ParryingWeaponItem> NETHERITE_QUARTERSTAFF = ITEMS.register(
            "netherite_quarterstaff", () -> new ParryingWeaponItem(Tiers.NETHERITE, BattleArchetypes.QUARTERSTAFF, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> STONE_GLAIVE = ITEMS.register(
            "stone_glaive", () -> new BaseWeaponItem(Tiers.STONE, BattleArchetypes.GLAIVE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> GOLDEN_GLAIVE = ITEMS.register(
            "golden_glaive", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.GLAIVE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_GLAIVE = ITEMS.register(
            "iron_glaive", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.GLAIVE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_GLAIVE = ITEMS.register(
            "steel_glaive", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.GLAIVE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_GLAIVE = ITEMS.register(
            "diamond_glaive", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.GLAIVE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_GLAIVE = ITEMS.register(
            "netherite_glaive", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.GLAIVE, new Item.Properties())
    );

    public static final DeferredItem<BaseWeaponItem> WOODEN_SCYTHE = ITEMS.register(
            "wooden_scythe", () -> new BaseWeaponItem(Tiers.WOOD, BattleArchetypes.SCYTHE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> GOLDEN_SCYTHE = ITEMS.register(
            "golden_scythe", () -> new BaseWeaponItem(Tiers.GOLD, BattleArchetypes.SCYTHE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> IRON_SCYTHE = ITEMS.register(
            "iron_scythe", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.SCYTHE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> STEEL_SCYTHE = ITEMS.register(
            "steel_scythe", () -> new BaseWeaponItem(BattleTiers.STEEL, BattleArchetypes.SCYTHE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> DIAMOND_SCYTHE = ITEMS.register(
            "diamond_scythe", () -> new BaseWeaponItem(Tiers.DIAMOND, BattleArchetypes.SCYTHE, new Item.Properties())
    );
    public static final DeferredItem<BaseWeaponItem> NETHERITE_SCYTHE = ITEMS.register(
            "netherite_scythe", () -> new BaseWeaponItem(Tiers.NETHERITE, BattleArchetypes.SCYTHE, new Item.Properties())
    );

    // RANGED WEAPONS


    // THROWING WEAPONS
    public static final DeferredItem<JavelinItem> FLINT_JAVELIN = ITEMS.register(
            "flint_javelin", () -> new JavelinItem(BattleTiers.FLINT, new Item.Properties())
    );
    public static final DeferredItem<JavelinItem> GOLDEN_JAVELIN = ITEMS.register(
            "golden_javelin", () -> new JavelinItem(Tiers.GOLD, new Item.Properties())
    );
    public static final DeferredItem<JavelinItem> IRON_JAVELIN = ITEMS.register(
            "iron_javelin", () -> new JavelinItem(Tiers.IRON, new Item.Properties())
    );
    public static final DeferredItem<JavelinItem> STEEL_JAVELIN = ITEMS.register(
            "steel_javelin", () -> new JavelinItem(BattleTiers.STEEL, new Item.Properties())
    );
    public static final DeferredItem<JavelinItem> DIAMOND_JAVELIN = ITEMS.register(
            "diamond_javelin", () -> new JavelinItem(Tiers.DIAMOND, new Item.Properties())
    );
    public static final DeferredItem<JavelinItem> NETHERITE_JAVELIN = ITEMS.register(
            "netherite_javelin", () -> new JavelinItem(Tiers.NETHERITE, new Item.Properties())
    );

    public static final DeferredItem<BoomerangItem> WOODEN_BOOMERANG = ITEMS.register(
            "wooden_boomerang", () -> new BoomerangItem(Tiers.WOOD, new Item.Properties())
    );
    public static final DeferredItem<BoomerangItem> GOLDEN_BOOMERANG = ITEMS.register(
            "golden_boomerang", () -> new BoomerangItem(Tiers.GOLD, new Item.Properties())
    );
    public static final DeferredItem<BoomerangItem> IRON_BOOMERANG = ITEMS.register(
            "iron_boomerang", () -> new BoomerangItem(Tiers.IRON, new Item.Properties())
    );
    public static final DeferredItem<BoomerangItem> STEEL_BOOMERANG = ITEMS.register(
            "steel_boomerang", () -> new BoomerangItem(BattleTiers.STEEL, new Item.Properties())
    );
    public static final DeferredItem<BoomerangItem> DIAMOND_BOOMERANG = ITEMS.register(
            "diamond_boomerang", () -> new BoomerangItem(Tiers.DIAMOND, new Item.Properties())
    );
    public static final DeferredItem<BoomerangItem> NETHERITE_BOOMERANG = ITEMS.register(
            "netherite_boomerang", () -> new BoomerangItem(Tiers.NETHERITE, new Item.Properties())
    );

    // MISC


    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }
}
