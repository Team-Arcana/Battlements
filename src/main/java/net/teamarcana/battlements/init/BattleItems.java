package net.teamarcana.battlements.init;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.item.BaseWeaponItem;

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

    // RANGED WEAPONS


    // THROWING WEAPONS

    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }
}
