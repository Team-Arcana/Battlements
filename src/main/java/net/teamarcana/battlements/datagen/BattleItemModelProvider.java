package net.teamarcana.battlements.datagen;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.loaders.SeparateTransformsModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.init.BattleItems;
import net.teamarcana.battlements.init.BattleModelOverrides;

import java.util.LinkedHashMap;
import java.util.Objects;

public class BattleItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static{
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public BattleItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Battlements.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(BattleItems.HANDLE.get());
        largeHandheldItem(BattleItems.POLE.get());
        simpleItem(BattleItems.COPPER_NUGGET);
        simpleItem(BattleItems.DIAMOND_SHARD);
        simpleItem(BattleItems.STEEL_INGOT);
        simpleItem(BattleItems.STEEL_NUGGET);
        simpleItem(BattleItems.NETHERITE_NUGGET);
        simpleItem(BattleItems.NETHERITE_NUGGET);
        simpleItem(BattleItems.ENDER_CRYSTAL);
        simpleItem(BattleItems.ENDERIUM_INGOT);
        simpleItem(BattleItems.ENDERIUM_NUGGET);
        simpleItem(BattleItems.ROCK);

        handheldItem(BattleItems.STEEL_SWORD.get());
        handheldItem(BattleItems.STEEL_PICKAXE.get());
        handheldItem(BattleItems.STEEL_AXE.get());
        handheldItem(BattleItems.STEEL_SHOVEL.get());
        handheldItem(BattleItems.STEEL_HOE.get());

        handheldItem(BattleItems.ENDERIUM_SWORD.get());
        handheldItem(BattleItems.ENDERIUM_PICKAXE.get());
        handheldItem(BattleItems.ENDERIUM_AXE.get());
        handheldItem(BattleItems.ENDERIUM_SHOVEL.get());
        handheldItem(BattleItems.ENDERIUM_HOE.get());

        // WOODEN WEAPONS
        handheldItem(BattleItems.WOODEN_DAGGER.get());
        largeHandheldItem(BattleItems.WOODEN_LONGSWORD.get());
        largeHandheldItem(BattleItems.WOODEN_GREATSWORD.get());
        largeHandheldItem(BattleItems.WOODEN_KATANA.get());
        handheldItem(BattleItems.WOODEN_RAPIER.get());
        handheldItem(BattleItems.WOODEN_SABER.get());
        handheldItem(BattleItems.WOODEN_CUTLASS.get());
        handheldItem(BattleItems.WOODEN_SICKLE.get());
        handheldItemWithExistingModel(BattleItems.WOODEN_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.WOODEN_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.WOODEN_GREATCLUB.get(), "battlements:item/base/greatclub_held");
        handheldItemWithExistingModel(BattleItems.WOODEN_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.WOODEN_WARHAMMER.get(), "battlements:item/base/warhammer_held");
        handheldItemWithExistingModel(BattleItems.WOODEN_MAUL.get(), "battlements:item/base/maul_held");
        largeHandheldItem(BattleItems.WOODEN_ANCHOR.get());
        handheldItem(BattleItems.WOODEN_WARPICK.get());
        handheldItem(BattleItems.WOODEN_BATTLEAXE.get());
        largeHandheldItem(BattleItems.WOODEN_GREATAXE.get());
        polearmHandheldItem(BattleItems.WOODEN_SPEAR.get());
        largePolearmHandheldItem(BattleItems.WOODEN_PIKE.get());
        polearmHandheldItem(BattleItems.WOODEN_QUARTERSTAFF.get());
        polearmHandheldItemAlt(BattleItems.WOODEN_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.WOODEN_HALBERD.get());
        polearmHandheldItem(BattleItems.WOODEN_PITCHFORK.get());;
        polearmHandheldItemAlt(BattleItems.WOODEN_SCYTHE.get());
        polearmHandheldItem(BattleItems.WOODEN_JAVELIN.get());
        handheldItemWithExistingModel2(BattleItems.WOODEN_BOOMERANG.get(), "battlements:item/base/boomerang_held");
        handheldItem(BattleItems.WOODEN_KUNAI.get());
        handheldItem(BattleItems.WOODEN_TOMAHAWK.get());
        handheldItem(BattleItems.WOODEN_THROWING_KNIFE.get());

        // STONE WEAPONS
        handheldItem(BattleItems.STONE_DAGGER.get());
        largeHandheldItem(BattleItems.STONE_LONGSWORD.get());
        largeHandheldItem(BattleItems.STONE_GREATSWORD.get());
        largeHandheldItem(BattleItems.STONE_KATANA.get());
        handheldItem(BattleItems.STONE_RAPIER.get());
        handheldItem(BattleItems.STONE_SABER.get());
        handheldItem(BattleItems.STONE_CUTLASS.get());
        handheldItem(BattleItems.STONE_SICKLE.get());
        handheldItemWithExistingModel(BattleItems.STONE_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.STONE_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.STONE_GREATCLUB.get(), "battlements:item/base/greatclub_held");
        handheldItemWithExistingModel(BattleItems.STONE_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.STONE_WARHAMMER.get(), "battlements:item/base/warhammer_held");
        handheldItemWithExistingModel(BattleItems.STONE_MAUL.get(), "battlements:item/base/maul_held");
        largeHandheldItem(BattleItems.STONE_ANCHOR.get());
        handheldItem(BattleItems.STONE_WARPICK.get());
        handheldItem(BattleItems.STONE_BATTLEAXE.get());
        largeHandheldItem(BattleItems.STONE_GREATAXE.get());
        polearmHandheldItem(BattleItems.STONE_SPEAR.get());
        largePolearmHandheldItem(BattleItems.STONE_PIKE.get());
        polearmHandheldItem(BattleItems.STONE_QUARTERSTAFF.get());
        polearmHandheldItemAlt(BattleItems.STONE_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.STONE_HALBERD.get());
        polearmHandheldItem(BattleItems.STONE_PITCHFORK.get());;
        polearmHandheldItemAlt(BattleItems.STONE_SCYTHE.get());
        polearmHandheldItem(BattleItems.STONE_JAVELIN.get());
        handheldItemWithExistingModel2(BattleItems.STONE_BOOMERANG.get(), "battlements:item/base/boomerang_held");
        handheldItem(BattleItems.STONE_KUNAI.get());
        handheldItem(BattleItems.STONE_TOMAHAWK.get());
        handheldItem(BattleItems.STONE_THROWING_KNIFE.get());

        // GOLDEN WEAPONS
        handheldItem(BattleItems.GOLDEN_DAGGER.get());
        largeHandheldItem(BattleItems.GOLDEN_LONGSWORD.get());
        largeHandheldItem(BattleItems.GOLDEN_GREATSWORD.get());
        largeHandheldItem(BattleItems.GOLDEN_KATANA.get());
        handheldItem(BattleItems.GOLDEN_RAPIER.get());
        handheldItem(BattleItems.GOLDEN_SABER.get());
        handheldItem(BattleItems.GOLDEN_CUTLASS.get());
        handheldItem(BattleItems.GOLDEN_SICKLE.get());
        handheldItemWithExistingModel(BattleItems.GOLDEN_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.GOLDEN_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.GOLDEN_GREATCLUB.get(), "battlements:item/base/greatclub_held");
        handheldItemWithExistingModel(BattleItems.GOLDEN_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.GOLDEN_WARHAMMER.get(), "battlements:item/base/warhammer_held");
        handheldItemWithExistingModel(BattleItems.GOLDEN_MAUL.get(), "battlements:item/base/maul_held");
        largeHandheldItem(BattleItems.GOLDEN_ANCHOR.get());
        handheldItem(BattleItems.GOLDEN_WARPICK.get());
        handheldItem(BattleItems.GOLDEN_BATTLEAXE.get());
        largeHandheldItem(BattleItems.GOLDEN_GREATAXE.get());
        polearmHandheldItem(BattleItems.GOLDEN_SPEAR.get());
        largePolearmHandheldItem(BattleItems.GOLDEN_PIKE.get());
        polearmHandheldItem(BattleItems.GOLDEN_QUARTERSTAFF.get());
        polearmHandheldItemAlt(BattleItems.GOLDEN_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.GOLDEN_HALBERD.get());
        polearmHandheldItem(BattleItems.GOLDEN_PITCHFORK.get());;
        polearmHandheldItemAlt(BattleItems.GOLDEN_SCYTHE.get());
        polearmHandheldItem(BattleItems.GOLDEN_JAVELIN.get());
        handheldItemWithExistingModel2(BattleItems.GOLDEN_BOOMERANG.get(), "battlements:item/base/boomerang_held");
        handheldItem(BattleItems.GOLDEN_KUNAI.get());
        handheldItem(BattleItems.GOLDEN_TOMAHAWK.get());
        handheldItem(BattleItems.GOLDEN_THROWING_KNIFE.get());

        // IRON WEAPONS
        handheldItem(BattleItems.IRON_DAGGER.get());
        largeHandheldItem(BattleItems.IRON_LONGSWORD.get());
        largeHandheldItem(BattleItems.IRON_GREATSWORD.get());
        largeHandheldItem(BattleItems.IRON_KATANA.get());
        handheldItem(BattleItems.IRON_RAPIER.get());
        handheldItem(BattleItems.IRON_SABER.get());
        handheldItem(BattleItems.IRON_CUTLASS.get());
        handheldItem(BattleItems.IRON_SICKLE.get());
        handheldItemWithExistingModel(BattleItems.IRON_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.IRON_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.IRON_GREATCLUB.get(), "battlements:item/base/greatclub_held");
        handheldItemWithExistingModel(BattleItems.IRON_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.IRON_WARHAMMER.get(), "battlements:item/base/warhammer_held");
        handheldItemWithExistingModel(BattleItems.IRON_MAUL.get(), "battlements:item/base/maul_held");
        largeHandheldItem(BattleItems.IRON_ANCHOR.get());
        handheldItem(BattleItems.IRON_WARPICK.get());
        handheldItem(BattleItems.IRON_BATTLEAXE.get());
        largeHandheldItem(BattleItems.IRON_GREATAXE.get());
        polearmHandheldItem(BattleItems.IRON_SPEAR.get());
        largePolearmHandheldItem(BattleItems.IRON_PIKE.get());
        polearmHandheldItem(BattleItems.IRON_QUARTERSTAFF.get());
        polearmHandheldItemAlt(BattleItems.IRON_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.IRON_HALBERD.get());
        polearmHandheldItem(BattleItems.IRON_PITCHFORK.get());;
        polearmHandheldItemAlt(BattleItems.IRON_SCYTHE.get());
        polearmHandheldItem(BattleItems.IRON_JAVELIN.get());
        handheldItemWithExistingModel2(BattleItems.IRON_BOOMERANG.get(), "battlements:item/base/boomerang_held");
        handheldItem(BattleItems.IRON_KUNAI.get());
        handheldItem(BattleItems.IRON_TOMAHAWK.get());
        handheldItem(BattleItems.IRON_THROWING_KNIFE.get());

        // STEEL WEAPONS
        handheldItem(BattleItems.STEEL_DAGGER.get());
        largeHandheldItem(BattleItems.STEEL_LONGSWORD.get());
        largeHandheldItem(BattleItems.STEEL_GREATSWORD.get());
        largeHandheldItem(BattleItems.STEEL_KATANA.get());
        handheldItem(BattleItems.STEEL_RAPIER.get());
        handheldItem(BattleItems.STEEL_SABER.get());
        handheldItem(BattleItems.STEEL_CUTLASS.get());
        handheldItem(BattleItems.STEEL_SICKLE.get());
        handheldItemWithExistingModel(BattleItems.STEEL_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.STEEL_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.STEEL_GREATCLUB.get(), "battlements:item/base/greatclub_held");
        handheldItemWithExistingModel(BattleItems.STEEL_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.STEEL_WARHAMMER.get(), "battlements:item/base/warhammer_held");
        handheldItemWithExistingModel(BattleItems.STEEL_MAUL.get(), "battlements:item/base/maul_held");
        largeHandheldItem(BattleItems.STEEL_ANCHOR.get());
        handheldItem(BattleItems.STEEL_WARPICK.get());
        handheldItem(BattleItems.STEEL_BATTLEAXE.get());
        largeHandheldItem(BattleItems.STEEL_GREATAXE.get());
        polearmHandheldItem(BattleItems.STEEL_SPEAR.get());
        largePolearmHandheldItem(BattleItems.STEEL_PIKE.get());
        polearmHandheldItem(BattleItems.STEEL_QUARTERSTAFF.get());
        polearmHandheldItemAlt(BattleItems.STEEL_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.STEEL_HALBERD.get());
        polearmHandheldItem(BattleItems.STEEL_PITCHFORK.get());;
        polearmHandheldItemAlt(BattleItems.STEEL_SCYTHE.get());
        polearmHandheldItem(BattleItems.STEEL_JAVELIN.get());
        handheldItemWithExistingModel2(BattleItems.STEEL_BOOMERANG.get(), "battlements:item/base/boomerang_held");
        handheldItem(BattleItems.STEEL_KUNAI.get());
        handheldItem(BattleItems.STEEL_TOMAHAWK.get());
        handheldItem(BattleItems.STEEL_THROWING_KNIFE.get());

        // DIAMOND WEAPONS
        handheldItem(BattleItems.DIAMOND_DAGGER.get());
        largeHandheldItem(BattleItems.DIAMOND_LONGSWORD.get());
        largeHandheldItem(BattleItems.DIAMOND_GREATSWORD.get());
        largeHandheldItem(BattleItems.DIAMOND_KATANA.get());
        handheldItem(BattleItems.DIAMOND_RAPIER.get());
        handheldItem(BattleItems.DIAMOND_SABER.get());
        handheldItem(BattleItems.DIAMOND_CUTLASS.get());
        handheldItem(BattleItems.DIAMOND_SICKLE.get());
        handheldItemWithExistingModel(BattleItems.DIAMOND_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.DIAMOND_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.DIAMOND_GREATCLUB.get(), "battlements:item/base/greatclub_held");
        handheldItemWithExistingModel(BattleItems.DIAMOND_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.DIAMOND_WARHAMMER.get(), "battlements:item/base/warhammer_held");
        handheldItemWithExistingModel(BattleItems.DIAMOND_MAUL.get(), "battlements:item/base/maul_held");
        largeHandheldItem(BattleItems.DIAMOND_ANCHOR.get());
        handheldItem(BattleItems.DIAMOND_WARPICK.get());
        handheldItem(BattleItems.DIAMOND_BATTLEAXE.get());
        largeHandheldItem(BattleItems.DIAMOND_GREATAXE.get());
        polearmHandheldItem(BattleItems.DIAMOND_SPEAR.get());
        largePolearmHandheldItem(BattleItems.DIAMOND_PIKE.get());
        polearmHandheldItem(BattleItems.DIAMOND_QUARTERSTAFF.get());
        polearmHandheldItemAlt(BattleItems.DIAMOND_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.DIAMOND_HALBERD.get());
        polearmHandheldItem(BattleItems.DIAMOND_PITCHFORK.get());;
        polearmHandheldItemAlt(BattleItems.DIAMOND_SCYTHE.get());
        polearmHandheldItem(BattleItems.DIAMOND_JAVELIN.get());
        handheldItemWithExistingModel2(BattleItems.DIAMOND_BOOMERANG.get(), "battlements:item/base/boomerang_held");
        handheldItem(BattleItems.DIAMOND_KUNAI.get());
        handheldItem(BattleItems.DIAMOND_TOMAHAWK.get());
        handheldItem(BattleItems.DIAMOND_THROWING_KNIFE.get());

        // NETHERITE WEAPONS
        handheldItem(BattleItems.NETHERITE_DAGGER.get());
        largeHandheldItem(BattleItems.NETHERITE_LONGSWORD.get());
        largeHandheldItem(BattleItems.NETHERITE_GREATSWORD.get());
        largeHandheldItem(BattleItems.NETHERITE_KATANA.get());
        handheldItem(BattleItems.NETHERITE_RAPIER.get());
        handheldItem(BattleItems.NETHERITE_SABER.get());
        handheldItem(BattleItems.NETHERITE_CUTLASS.get());
        handheldItem(BattleItems.NETHERITE_SICKLE.get());
        handheldItemWithExistingModel(BattleItems.NETHERITE_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.NETHERITE_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.NETHERITE_GREATCLUB.get(), "battlements:item/base/greatclub_held");
        handheldItemWithExistingModel(BattleItems.NETHERITE_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.NETHERITE_WARHAMMER.get(), "battlements:item/base/warhammer_held");
        handheldItemWithExistingModel(BattleItems.NETHERITE_MAUL.get(), "battlements:item/base/maul_held");
        largeHandheldItem(BattleItems.NETHERITE_ANCHOR.get());
        handheldItem(BattleItems.NETHERITE_WARPICK.get());
        handheldItem(BattleItems.NETHERITE_BATTLEAXE.get());
        largeHandheldItem(BattleItems.NETHERITE_GREATAXE.get());
        polearmHandheldItem(BattleItems.NETHERITE_SPEAR.get());
        largePolearmHandheldItem(BattleItems.NETHERITE_PIKE.get());
        polearmHandheldItem(BattleItems.NETHERITE_QUARTERSTAFF.get());
        polearmHandheldItemAlt(BattleItems.NETHERITE_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.NETHERITE_HALBERD.get());
        polearmHandheldItem(BattleItems.NETHERITE_PITCHFORK.get());;
        polearmHandheldItemAlt(BattleItems.NETHERITE_SCYTHE.get());
        polearmHandheldItem(BattleItems.NETHERITE_JAVELIN.get());
        handheldItemWithExistingModel2(BattleItems.NETHERITE_BOOMERANG.get(), "battlements:item/base/boomerang_held");
        handheldItem(BattleItems.NETHERITE_KUNAI.get());
        handheldItem(BattleItems.NETHERITE_TOMAHAWK.get());
        handheldItem(BattleItems.NETHERITE_THROWING_KNIFE.get());

        // ENDERIUM WEAPONS
        handheldItem(BattleItems.ENDERIUM_DAGGER.get());
        largeHandheldItem(BattleItems.ENDERIUM_LONGSWORD.get());
        largeHandheldItem(BattleItems.ENDERIUM_GREATSWORD.get());
        largeHandheldItem(BattleItems.ENDERIUM_KATANA.get());
        handheldItem(BattleItems.ENDERIUM_RAPIER.get());
        handheldItem(BattleItems.ENDERIUM_SABER.get());
        handheldItem(BattleItems.ENDERIUM_CUTLASS.get());
        handheldItem(BattleItems.ENDERIUM_SICKLE.get());
        handheldItemWithExistingModel(BattleItems.ENDERIUM_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.ENDERIUM_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.ENDERIUM_GREATCLUB.get(), "battlements:item/base/greatclub_held");
        handheldItemWithExistingModel(BattleItems.ENDERIUM_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.ENDERIUM_WARHAMMER.get(), "battlements:item/base/warhammer_held");
        handheldItemWithExistingModel(BattleItems.ENDERIUM_MAUL.get(), "battlements:item/base/maul_held");
        largeHandheldItem(BattleItems.ENDERIUM_ANCHOR.get());
        handheldItem(BattleItems.ENDERIUM_WARPICK.get());
        handheldItem(BattleItems.ENDERIUM_BATTLEAXE.get());
        largeHandheldItem(BattleItems.ENDERIUM_GREATAXE.get());
        polearmHandheldItem(BattleItems.ENDERIUM_SPEAR.get());
        largePolearmHandheldItem(BattleItems.ENDERIUM_PIKE.get());
        polearmHandheldItem(BattleItems.ENDERIUM_QUARTERSTAFF.get());
        polearmHandheldItemAlt(BattleItems.ENDERIUM_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.ENDERIUM_HALBERD.get());
        polearmHandheldItem(BattleItems.ENDERIUM_PITCHFORK.get());;
        polearmHandheldItemAlt(BattleItems.ENDERIUM_SCYTHE.get());
        polearmHandheldItem(BattleItems.ENDERIUM_JAVELIN.get());
        handheldItemWithExistingModel2(BattleItems.ENDERIUM_BOOMERANG.get(), "battlements:item/base/boomerang_held");
        handheldItem(BattleItems.ENDERIUM_KUNAI.get());
        handheldItem(BattleItems.ENDERIUM_TOMAHAWK.get());
        handheldItem(BattleItems.ENDERIUM_THROWING_KNIFE.get());
    }

    // METHODS
    // Shoutout to El_Redstoniano for making this
    // [Obtained from a tutorial by kaupenjoe]
    private void trimmedArmorItem(DeferredItem itemRegistryObject) {
        final String MOD_ID = Battlements.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(DeferredItem item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "item/"+item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(DeferredBlock item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(Block block) {
        this.withExistingParent(Battlements.MOD_ID + ":" + Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block)),
                modLoc("block/" + Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block))));
    }

    public ItemModelBuilder handheldItem(Item item) {
        return handheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder handheldItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }

    public ItemModelBuilder largeHandheldItem(Item item){
        return largeHandheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder largeHandheldItem(ResourceLocation item){
        ItemModelBuilder heldModel = largeHeldItem(item);
        ItemModelBuilder inventoryModel = inventoryItem(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder handheldItemWithExistingModel(Item item, String existingModelPath){
        return handheldItemWithExistingModel(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), existingModelPath);
    }
    public ItemModelBuilder handheldItemWithExistingModel(ResourceLocation item, String existingModelPath){
        ItemModelBuilder heldModel = heldItemWithExistingModel(item, existingModelPath);
        ItemModelBuilder inventoryModel = inventoryItem(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder inventoryItem(ResourceLocation item) {
        return withExistingParent(item + "_inventory",
                "item/handheld")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
    public ItemModelBuilder largeHeldItem(ResourceLocation item) {
        return withExistingParent(item + "_held",
                "battlements:item/base/large_handheld")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder heldItemWithExistingModel(ResourceLocation item, String existingModelPath) {
        return withExistingParent(item + "_held",
                existingModelPath)
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder polearmHandheldItem(Item item){
        return polearmHandheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder polearmHandheldItem(ResourceLocation item){
        ItemModelBuilder heldModel = polearm_held_item(item);
        ItemModelBuilder inventoryModel = inventoryItem(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder polearm_held_item(ResourceLocation item) {
        return withExistingParent(item + "_held",
                "battlements:item/base/polearm_held")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder largePolearmHandheldItem(Item item){
        return largePolearmHandheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder largePolearmHandheldItem(ResourceLocation item){
        ItemModelBuilder heldModel = largePolearm_held_item(item);
        ItemModelBuilder inventoryModel = inventoryItem(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder largePolearm_held_item(ResourceLocation item) {
        return withExistingParent(item + "_held",
                "battlements:item/base/large_polearm_held")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder polearmHandheldItemAlt(Item item){
        return polearmHandheldItemAlt(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder polearmHandheldItemAlt(ResourceLocation item){
        ItemModelBuilder heldModel = polearm_held_itemAlt(item);
        ItemModelBuilder inventoryModel = inventoryItem(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder polearm_held_itemAlt(ResourceLocation item) {
        return withExistingParent(item + "_held",
                "battlements:item/base/polearm_alt_held")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder handheldItemWithExistingModel2(Item item, String existingModelPath){
        return handheldItemWithExistingModel2(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), existingModelPath);
    }
    public ItemModelBuilder handheldItemWithExistingModel2(ResourceLocation item, String existingModelPath){
        ItemModelBuilder heldModel = heldItemWithExistingModel2(item, existingModelPath);
        ItemModelBuilder inventoryModel = inventoryItem(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder heldItemWithExistingModel2(ResourceLocation item, String existingModelPath) {
        return withExistingParent(item + "_held",
                existingModelPath)
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }

    // Weapon Item Modeling
    public ItemModelBuilder weaponItem(Item item){
        return weaponItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder weaponItem(ResourceLocation item){
        ItemModelBuilder heldModel = weaponItemHandheld(item);
        ItemModelBuilder parryModel = weaponItemParrying(item);
        ItemModelBuilder throwingModel = weaponItemThrowing(item);
        return withExistingParent(item.toString(), heldModel.getLocation())
                .override().predicate(BattleModelOverrides.PARRYING, 1.0f).model(new ModelFile.ExistingModelFile(parryModel.getLocation(), existingFileHelper)).end()
                .override().predicate(BattleModelOverrides.THROWING, 1.0f).model(new ModelFile.ExistingModelFile(throwingModel.getLocation(), existingFileHelper)).end();
    }

    // normal
    public ItemModelBuilder weaponItemHandheld(ResourceLocation item) {
        return withExistingParent(item + "_held",
                "battlements:item/base/handheld")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }

    // parrying
    public ItemModelBuilder weaponItemParrying(ResourceLocation item) {
        return withExistingParent(item + "_parrying",
                "battlements:item/base/handheld_parrying")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }

    // throwing
    public ItemModelBuilder weaponItemThrowing(ResourceLocation item) {
        return withExistingParent(item + "_throwing",
                "battlements:item/base/handheld_throwing")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }

    // Large Weapon Item Modeling
    public ItemModelBuilder largeWeaponItem(Item item){
        return largeWeaponItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder largeWeaponItem(ResourceLocation item){
        ItemModelBuilder heldModel = largeWeaponItemHandheld(item);
        ItemModelBuilder parryModel = largeWeaponItemParrying(item);
        ItemModelBuilder throwingModel = largeWeaponItemThrowing(item);
        return withExistingParent(item.toString(), heldModel.getLocation())
                .override().predicate(BattleModelOverrides.PARRYING, 1.0f).model(new ModelFile.ExistingModelFile(parryModel.getLocation(), existingFileHelper)).end()
                .override().predicate(BattleModelOverrides.THROWING, 1.0f).model(new ModelFile.ExistingModelFile(throwingModel.getLocation(), existingFileHelper)).end();
    }

    // normal
    public ItemModelBuilder largeWeaponItemHandheld(ResourceLocation item) {
        return withExistingParent(item + "_held",
                "battlements:item/base/large_handheld")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder largeWeaponItemHandheldInHand(ResourceLocation item) {
        return withExistingParent(item + "_held_in_hand",
                "battlements:item/base/large_handheld")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder largeWeaponItemHandheldInInventory(ResourceLocation item) {
        return withExistingParent(item + "_held_in_inventory",
                "battlements:item/base/large_handheld")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }

    // parrying
    public ItemModelBuilder largeWeaponItemParrying(ResourceLocation item) {
        return withExistingParent(item + "_parrying",
                "battlements:item/base/handheld_parrying")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
    public ItemModelBuilder largeWeaponItemParryingInHand(ResourceLocation item) {
        return withExistingParent(item + "_parrying_in_hand",
                "battlements:item/base/handheld_parrying")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
    public ItemModelBuilder largeWeaponItemParryingInInventory(ResourceLocation item) {
        return withExistingParent(item + "_parrying_in_inventory",
                "battlements:item/base/handheld_parrying")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }

    // throwing
    public ItemModelBuilder largeWeaponItemThrowing(ResourceLocation item) {
        return withExistingParent(item + "_throwing",
                "battlements:item/base/handheld_throwing")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
    public ItemModelBuilder largeWeaponItemThrowingInHand(ResourceLocation item) {
        return withExistingParent(item + "_throwing_in_hand",
                "battlements:item/base/handheld_throwing")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
    public ItemModelBuilder largeWeaponItemThrowingInInventory(ResourceLocation item) {
        return withExistingParent(item + "_throwing_in_inventory",
                "battlements:item/base/handheld_throwing")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
}
