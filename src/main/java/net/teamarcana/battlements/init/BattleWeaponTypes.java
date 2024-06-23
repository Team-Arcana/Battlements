package net.teamarcana.battlements.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.ToolActions;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.weapon_trait.Trait;
import net.teamarcana.battlements.api.weapon_type.WeaponType;

import java.util.function.Supplier;

public class BattleWeaponTypes {
    public static final ResourceKey<Registry<WeaponType>> REGISTRY_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "weapon_types"));
    public static final Registry<WeaponType> WEAPON_TYPE_REGISTRY = new RegistryBuilder<WeaponType>(REGISTRY_KEY).create();
    public static final DeferredRegister<WeaponType> WEAPON_TYPES = DeferredRegister.create(REGISTRY_KEY, Battlements.MOD_ID);

    // Weapon Types
    public static final Supplier<WeaponType> DAGGER = WEAPON_TYPES.register("dagger", () -> new WeaponType(
            "dagger", 2.5f, 1.0f, 2.5f,
            true, BattleTags.Traits.DAGGER, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> LONGSWORD = WEAPON_TYPES.register("longsword", () -> new WeaponType(
            "longsword", 4.5f, 1.5f, 1.4f,
            true, BattleTags.Traits.LONGSWORD, WeaponType.MELEE, ToolActions.SWORD_DIG
    ));
    public static final Supplier<WeaponType> GREATSWORD = WEAPON_TYPES.register("greatsword", () -> new WeaponType(
            "greatsword", 5.0f, 1.5f, 1.3f,
            true, BattleTags.Traits.GREATSWORD, WeaponType.MELEE, ToolActions.SWORD_DIG
    ));
    public static final Supplier<WeaponType> KATANA = WEAPON_TYPES.register("katana", () -> new WeaponType(
            "katana", 3.5f, 0.5f, 2.0f,
            true, BattleTags.Traits.KATANA, WeaponType.MELEE, ToolActions.SWORD_DIG
    ));
    public static final Supplier<WeaponType> RAPIER = WEAPON_TYPES.register("rapier", () -> new WeaponType(
            "rapier", 2, 0.5f, 2.4f,
            true, BattleTags.Traits.RAPIER, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> SABER = WEAPON_TYPES.register("saber", () -> new WeaponType(
            "saber", 3.5f, 0.5f, 1.6f,
            true, BattleTags.Traits.SABER, WeaponType.MELEE, ToolActions.SWORD_DIG
    ));
    public static final Supplier<WeaponType> CUTLASS = WEAPON_TYPES.register("cutlass", () -> new WeaponType(
            "cutlass", 3f ,0.5f, 1.6f,
            true, BattleTags.Traits.CUTLASS, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> SICKLE = WEAPON_TYPES.register("sickle", () -> new WeaponType(
            "sickle", 2, 1.0f, 1.9f,
            true, BattleTags.Traits.SICKLE, WeaponType.MELEE, ToolActions.DEFAULT_HOE_ACTIONS
    ));
    public static final Supplier<WeaponType> CLAW = WEAPON_TYPES.register("claw", () -> new WeaponType(
            "claw", 2.0f, 0.5f, 3.5f,
            true, BattleTags.Traits.CLAW, WeaponType.MELEE, ToolActions.SHOVEL_DIG, ToolActions.SHOVEL_FLATTEN
    ));

    public static final Supplier<WeaponType> CLUB = WEAPON_TYPES.register("club", () -> new WeaponType(
            "club", 4.0f, 1.0f, 1.3f,
            false, BattleTags.Traits.CLUB, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> GREATCLUB = WEAPON_TYPES.register("greatclub", () -> new WeaponType(
            "greatclub", 4.5f, 1.5f, 0.9f,
            false, BattleTags.Traits.GREATCLUB, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> HAMMER = WEAPON_TYPES.register("hammer", () -> new WeaponType(
            "hammer", 4.2f, 1.5f, 1.0f,
            false, BattleTags.Traits.HAMMER, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> WARHAMMER = WEAPON_TYPES.register("warhammer", () -> new WeaponType(
            "warhammer", 4.0f, 1.5f, 1.1f,
            false, BattleTags.Traits.WARHAMMER, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> MAUL = WEAPON_TYPES.register("maul", () -> new WeaponType(
            "maul", 5.0f, 2.0f, 0.75f,
            false, BattleTags.Traits.MAUL, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> MACE = WEAPON_TYPES.register("mace", () -> new WeaponType(
            "mace", 3.0f, 1.5f,1.2f,
            false, BattleTags.Traits.MACE, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> ANCHOR = WEAPON_TYPES.register("anchor", () -> new WeaponType(
            "anchor", 4.1f, 1.6f, 1.0f,
            false, BattleTags.Traits.ANCHOR, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> WARPICK = WEAPON_TYPES.register("warpick", () -> new WeaponType(
            "warpick", 3.0f, 1.0f, 1.5f,
            true, BattleTags.Traits.WARPICK, WeaponType.MELEE, ToolActions.DEFAULT_PICKAXE_ACTIONS
    ));
    public static final Supplier<WeaponType> BATTLEAXE = WEAPON_TYPES.register("battleaxe", () -> new WeaponType(
            "battleaxe", 4.0f, 2.0f, 1.0f,
            true, BattleTags.Traits.BATTLEAXE, WeaponType.MELEE, ToolActions.DEFAULT_AXE_ACTIONS
    ));
    public static final Supplier<WeaponType> GREATAXE = WEAPON_TYPES.register("greataxe", () -> new WeaponType(
            "greataxe", 4.2f, 2.1f, 0.8f,
            true, BattleTags.Traits.GREATAXE, WeaponType.MELEE, ToolActions.DEFAULT_AXE_ACTIONS
    ));

    public static final Supplier<WeaponType> SPEAR = WEAPON_TYPES.register("spear", () -> new WeaponType(
            "spear", 5.5f, 0.5f, 1.4f,
            true, BattleTags.Traits.SPEAR, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> PIKE = WEAPON_TYPES.register("pike", () -> new WeaponType(
            "pike", 4.0f, 1.0f, 1.4f,
            true, BattleTags.Traits.PIKE, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> QUARTERSTAFF = WEAPON_TYPES.register("quarterstaff", () -> new WeaponType(
            "quarterstaff", 3.0f, 1.5f, 1.4f,
            false, BattleTags.Traits.QUARTERSTAFF, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> HALBERD = WEAPON_TYPES.register("halberd", () -> new WeaponType(
            "halberd", 5.0f, 1.5f, 1.2f,
            true, BattleTags.Traits.HALBERD, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> GLAIVE = WEAPON_TYPES.register("glaive", () -> new WeaponType(
            "glaive", 4.0f, 1.5f, 1.0f,
            true, BattleTags.Traits.GLAIVE, WeaponType.MELEE
    ));
    public static final Supplier<WeaponType> SCYTHE = WEAPON_TYPES.register("scythe", () -> new WeaponType(
            "scythe", 5.0f, 1.0f, 1.0f,
            true, BattleTags.Traits.SCYTHE, WeaponType.MELEE, ToolActions.DEFAULT_HOE_ACTIONS
    ));
    public static final Supplier<WeaponType> PITCHFORK = WEAPON_TYPES.register("pitchfork", () -> new WeaponType(
            "pitchfork", 5, 0.5f, 1.2f,
            true, BattleTags.Traits.PITCHFORK, WeaponType.MELEE
    ));

    public static final Supplier<WeaponType> JAVELIN = WEAPON_TYPES.register("javelin", () -> new WeaponType(
            "javelin", 1.5f, 1.0f, 1.2f,
            false, BattleTags.Traits.JAVELIN, WeaponType.THROWING
    ));
    public static final Supplier<WeaponType> BOOMERANG = WEAPON_TYPES.register("boomerang", () -> new WeaponType(
            "boomerang", 4, 1, 2,
            false, BattleTags.Traits.BOOMERANG, WeaponType.THROWING
    ));

    public static void register(IEventBus eventBus){
        WEAPON_TYPES.register(eventBus);
    }
}
