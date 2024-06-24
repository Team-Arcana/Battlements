package net.teamarcana.battlements.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
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
    public static final DeferredItem<Item> ENDER_CRYSTAL = ITEMS.registerSimpleItem("ender_crystal", new Item.Properties());
    public static final DeferredItem<Item> ENDERIUM_INGOT = ITEMS.registerSimpleItem("enderium_ingot", new Item.Properties());

    // WEAPON TYPES
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
            "iron_saber", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.RAPIER, new Item.Properties()));
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
    public static final DeferredItem<BaseWeaponItem> IRON_MACE = ITEMS.register(
            "iron_mace", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.MACE, new Item.Properties()));
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
            "iron_kunai", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.KUNAI, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_TOMAHAWK = ITEMS.register(
            "iron_tomahawk", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.TOMAHAWK, new Item.Properties()));
    public static final DeferredItem<BaseWeaponItem> IRON_THROWING_KNIFE = ITEMS.register(
            "iron_throwing_knife", () -> new BaseWeaponItem(Tiers.IRON, BattleArchetypes.THROWING_KNIFE, new Item.Properties()));

    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }
}
