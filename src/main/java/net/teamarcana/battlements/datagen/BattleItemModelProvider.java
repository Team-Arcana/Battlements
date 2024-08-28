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
        simpleItem(BattleItems.DIAMOND_SHARD);
        simpleItem(BattleItems.STEEL_INGOT);
        simpleItem(BattleItems.STEEL_NUGGET);
        simpleItem(BattleItems.NETHERITE_NUGGET);
        simpleItem(BattleItems.NETHERITE_NUGGET);

        handheldItem(BattleItems.STEEL_SWORD.get());
        handheldItem(BattleItems.STEEL_PICKAXE.get());
        handheldItem(BattleItems.STEEL_AXE.get());
        handheldItem(BattleItems.STEEL_SHOVEL.get());
        handheldItem(BattleItems.STEEL_HOE.get());

        largeHandheldItem(BattleItems.STONE_BATTLEAXE.get());
        largeHandheldItem(BattleItems.GOLDEN_BATTLEAXE.get());
        largeHandheldItem(BattleItems.IRON_BATTLEAXE.get());
        largeHandheldItem(BattleItems.STEEL_BATTLEAXE.get());
        largeHandheldItem(BattleItems.DIAMOND_BATTLEAXE.get());
        largeHandheldItem(BattleItems.NETHERITE_BATTLEAXE.get());

        largeHandheldItem(BattleItems.STONE_GREATSWORD.get());
        largeHandheldItem(BattleItems.GOLDEN_GREATSWORD.get());
        largeHandheldItem(BattleItems.IRON_GREATSWORD.get());
        largeHandheldItem(BattleItems.STEEL_GREATSWORD.get());
        largeHandheldItem(BattleItems.DIAMOND_GREATSWORD.get());
        largeHandheldItem(BattleItems.NETHERITE_GREATSWORD.get());

        largeHandheldItem(BattleItems.GOLDEN_ANCHOR.get());
        largeHandheldItem(BattleItems.IRON_ANCHOR.get());
        largeHandheldItem(BattleItems.STEEL_ANCHOR.get());
        largeHandheldItem(BattleItems.DIAMOND_ANCHOR.get());
        largeHandheldItem(BattleItems.NETHERITE_ANCHOR.get());

        handheldItem(BattleItems.FLINT_DAGGER.get());
        handheldItem(BattleItems.GOLDEN_DAGGER.get());
        handheldItem(BattleItems.BONE_DAGGER.get());
        handheldItem(BattleItems.IRON_DAGGER.get());
        handheldItem(BattleItems.STEEL_DAGGER.get());
        handheldItem(BattleItems.DIAMOND_DAGGER.get());
        handheldItem(BattleItems.NETHERITE_DAGGER.get());

        handheldItem(BattleItems.GOLDEN_RAPIER.get());
        handheldItem(BattleItems.IRON_RAPIER.get());
        handheldItem(BattleItems.STEEL_RAPIER.get());
        handheldItem(BattleItems.DIAMOND_RAPIER.get());
        handheldItem(BattleItems.NETHERITE_RAPIER.get());

        handheldItem(BattleItems.WOODEN_CUTLASS.get());
        handheldItem(BattleItems.GOLDEN_CUTLASS.get());
        handheldItem(BattleItems.IRON_CUTLASS.get());
        handheldItem(BattleItems.STEEL_CUTLASS.get());
        handheldItem(BattleItems.DIAMOND_CUTLASS.get());
        handheldItem(BattleItems.NETHERITE_CUTLASS.get());

        handheldItem(BattleItems.GOLDEN_SICKLE.get());
        handheldItem(BattleItems.IRON_SICKLE.get());
        handheldItem(BattleItems.STEEL_SICKLE.get());
        handheldItem(BattleItems.DIAMOND_SICKLE.get());
        handheldItem(BattleItems.NETHERITE_SICKLE.get());

        polearmHandheldItemAlt(BattleItems.FLINT_SPEAR.get());
        polearmHandheldItemAlt(BattleItems.GOLDEN_SPEAR.get());
        polearmHandheldItemAlt(BattleItems.IRON_SPEAR.get());
        polearmHandheldItemAlt(BattleItems.STEEL_SPEAR.get());
        polearmHandheldItemAlt(BattleItems.DIAMOND_SPEAR.get());
        polearmHandheldItemAlt(BattleItems.NETHERITE_SPEAR.get());

        polearmHandheldItemAlt(BattleItems.STONE_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.GOLDEN_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.IRON_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.STEEL_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.DIAMOND_GLAIVE.get());
        polearmHandheldItemAlt(BattleItems.NETHERITE_GLAIVE.get());

        polearmHandheldItemAlt(BattleItems.WOODEN_SCYTHE.get());
        polearmHandheldItemAlt(BattleItems.GOLDEN_SCYTHE.get());
        polearmHandheldItemAlt(BattleItems.IRON_SCYTHE.get());
        polearmHandheldItemAlt(BattleItems.STEEL_SCYTHE.get());
        polearmHandheldItemAlt(BattleItems.DIAMOND_SCYTHE.get());
        polearmHandheldItemAlt(BattleItems.NETHERITE_SCYTHE.get());

        handheldItemWithExistingModel(BattleItems.WOODEN_CLUB.get(), "battlements:item/base/club_held");
        handheldItemWithExistingModel(BattleItems.BONE_CLUB.get(), "battlements:item/base/bone_club_held");

        handheldItemWithExistingModel(BattleItems.GOLDEN_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.IRON_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.STEEL_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.DIAMOND_HAMMER.get(), "battlements:item/base/hammer_held");
        handheldItemWithExistingModel(BattleItems.NETHERITE_HAMMER.get(), "battlements:item/base/hammer_held");

        handheldItemWithExistingModel(BattleItems.FLINT_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.GOLDEN_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.IRON_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.STEEL_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.DIAMOND_CLAW.get(), "battlements:item/base/claw_held");
        handheldItemWithExistingModel(BattleItems.NETHERITE_CLAW.get(), "battlements:item/base/claw_held");

        largeWeaponItem(BattleItems.GOLDEN_KATANA.get());
        largeWeaponItem(BattleItems.IRON_KATANA.get());
        largeWeaponItem(BattleItems.STEEL_KATANA.get());
        largeWeaponItem(BattleItems.DIAMOND_KATANA.get());
        largeWeaponItem(BattleItems.NETHERITE_KATANA.get());

        polearmWeaponItem(BattleItems.WOODEN_QUARTERSTAFF.get());
        polearmWeaponItem(BattleItems.GOLDEN_QUARTERSTAFF.get());
        polearmWeaponItem(BattleItems.IRON_QUARTERSTAFF.get());
        polearmWeaponItem(BattleItems.STEEL_QUARTERSTAFF.get());
        polearmWeaponItem(BattleItems.DIAMOND_QUARTERSTAFF.get());
        polearmWeaponItem(BattleItems.NETHERITE_QUARTERSTAFF.get());

        polearmWeaponItem(BattleItems.FLINT_JAVELIN.get());
        polearmWeaponItem(BattleItems.GOLDEN_JAVELIN.get());
        polearmWeaponItem(BattleItems.IRON_JAVELIN.get());
        polearmWeaponItem(BattleItems.STEEL_JAVELIN.get());
        polearmWeaponItem(BattleItems.DIAMOND_JAVELIN.get());
        polearmWeaponItem(BattleItems.NETHERITE_JAVELIN.get());

        weaponItem(BattleItems.WOODEN_BOOMERANG.get());
        weaponItem(BattleItems.GOLDEN_BOOMERANG.get());
        weaponItem(BattleItems.IRON_BOOMERANG.get());
        weaponItem(BattleItems.STEEL_BOOMERANG.get());
        weaponItem(BattleItems.DIAMOND_BOOMERANG.get());
        weaponItem(BattleItems.NETHERITE_BOOMERANG.get());
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
    public ItemModelBuilder heldItemWithExistingModel(ResourceLocation item, String existingModelPath) {
        return withExistingParent(item + "_held",
                existingModelPath)
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder largeHeldItem(ResourceLocation item) {
        return withExistingParent(item + "_held",
                "battlements:item/base/large_handheld")
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
        ItemModelBuilder heldModel = largeWeaponItemHandheldInHand(item);
        ItemModelBuilder inventoryModel = largeWeaponItemHandheldInInventory(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
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
        ItemModelBuilder heldModel = largeWeaponItemParryingInHand(item);
        ItemModelBuilder inventoryModel = largeWeaponItemParryingInInventory(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
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
        ItemModelBuilder heldModel = largeWeaponItemThrowingInHand(item);
        ItemModelBuilder inventoryModel = largeWeaponItemThrowingInInventory(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
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



    // Large Weapon Item Modeling
    public ItemModelBuilder polearmWeaponItem(Item item){
        return polearmWeaponItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder polearmWeaponItem(ResourceLocation item){
        ItemModelBuilder heldModel = polearmWeaponItemHandheld(item);
        ItemModelBuilder parryModel = polearmWeaponItemParrying(item);
        ItemModelBuilder throwingModel = polearmWeaponItemThrowing(item);
        return withExistingParent(item.toString(), heldModel.getLocation())
                .override().predicate(BattleModelOverrides.PARRYING, 1.0f).model(new ModelFile.ExistingModelFile(parryModel.getLocation(), existingFileHelper)).end()
                .override().predicate(BattleModelOverrides.THROWING, 1.0f).model(new ModelFile.ExistingModelFile(throwingModel.getLocation(), existingFileHelper)).end();
    }

    // normal
    public ItemModelBuilder polearmWeaponItemHandheld(ResourceLocation item) {
        ItemModelBuilder heldModel = polearmWeaponItemHandheldInHand(item);
        ItemModelBuilder inventoryModel = polearmWeaponItemHandheldInInventory(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder polearmWeaponItemHandheldInHand(ResourceLocation item) {
        return withExistingParent(item + "_held_in_hand",
                "battlements:item/base/polearm_held")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }
    public ItemModelBuilder polearmWeaponItemHandheldInInventory(ResourceLocation item) {
        return withExistingParent(item + "_held_in_inventory",
                "battlements:item/base/polearm_held")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_held"));
    }

    // parrying
    public ItemModelBuilder polearmWeaponItemParrying(ResourceLocation item) {
        ItemModelBuilder heldModel = polearmWeaponItemParryingInHand(item);
        ItemModelBuilder inventoryModel = polearmWeaponItemParryingInInventory(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder polearmWeaponItemParryingInHand(ResourceLocation item) {
        return withExistingParent(item + "_parrying_in_hand",
                "battlements:item/base/polearm_parrying")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
    public ItemModelBuilder polearmWeaponItemParryingInInventory(ResourceLocation item) {
        return withExistingParent(item + "_parrying_in_inventory",
                "battlements:item/base/handheld_parrying")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }

    // throwing
    public ItemModelBuilder polearmWeaponItemThrowing(ResourceLocation item) {
        ItemModelBuilder heldModel = polearmWeaponItemThrowingInHand(item);
        ItemModelBuilder inventoryModel = polearmWeaponItemThrowingInInventory(item);

        return getBuilder(String.valueOf(item)).customLoader(SeparateTransformsModelBuilder::begin)
                .base(heldModel)
                .perspective(ItemDisplayContext.GUI, inventoryModel)
                .perspective(ItemDisplayContext.FIXED, inventoryModel).end().guiLight(BlockModel.GuiLight.FRONT);
    }
    public ItemModelBuilder polearmWeaponItemThrowingInHand(ResourceLocation item) {
        return withExistingParent(item + "_throwing_in_hand",
                "battlements:item/base/polearm_throwing")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
    public ItemModelBuilder polearmWeaponItemThrowingInInventory(ResourceLocation item) {
        return withExistingParent(item + "_throwing_in_inventory",
                "battlements:item/base/handheld_throwing")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
}
