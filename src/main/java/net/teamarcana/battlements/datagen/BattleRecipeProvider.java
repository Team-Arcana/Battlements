package net.teamarcana.battlements.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.teamarcana.battlements.init.BattleBlocks;
import net.teamarcana.battlements.init.BattleItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BattleRecipeProvider extends RecipeProvider {
    public static final List<ItemLike> STEEL_SMELTABLES = List.of(Items.IRON_INGOT);
    public static final List<ItemLike> LEATHER_COOKABLES = List.of(Items.ROTTEN_FLESH);


    public BattleRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        oreSmelting(output, LEATHER_COOKABLES, RecipeCategory.MISC, Items.LEATHER, 0.25f, 100, "leather");
        smokingRecipe(output, LEATHER_COOKABLES, RecipeCategory.MISC, Items.LEATHER, 0.25f, 100, "leather");
        campfireRecipe(output, LEATHER_COOKABLES, RecipeCategory.MISC, Items.LEATHER, 0.25f, 100, "leather");

        oreBlasting(output, STEEL_SMELTABLES, RecipeCategory.MISC, BattleItems.STEEL_INGOT, 0.25f, 100, "steel_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.STEEL_INGOT, 9)
                .requires(BattleItems.STEEL_BLOCK)
                .unlockedBy(getHasName(BattleItems.STEEL_BLOCK), has(BattleItems.STEEL_BLOCK))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BattleItems.STEEL_BLOCK)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', BattleItems.STEEL_INGOT)
                .unlockedBy(getHasName(BattleItems.STEEL_INGOT), has(BattleItems.STEEL_INGOT))
                .save(output, getItemName(BattleItems.STEEL_BLOCK));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.STEEL_NUGGET, 9)
                .requires(BattleItems.STEEL_INGOT)
                .unlockedBy(getHasName(BattleItems.STEEL_INGOT), has(BattleItems.STEEL_INGOT))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BattleItems.STEEL_INGOT)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', BattleItems.STEEL_NUGGET)
                .unlockedBy(getHasName(BattleItems.STEEL_NUGGET), has(BattleItems.STEEL_NUGGET))
                .save(output, getItemName(BattleItems.STEEL_INGOT) + "_from_nuggets");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.NETHERITE_NUGGET.get(), 9)
                .requires(Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NETHERITE_INGOT)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', BattleItems.NETHERITE_NUGGET.get())
                .unlockedBy(getHasName(BattleItems.NETHERITE_NUGGET.get()), has(BattleItems.NETHERITE_NUGGET.get()))
                .save(output, getItemName(Items.NETHERITE_INGOT) + "_from_nuggets");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.DIAMOND_SHARD.get(), 9)
                .requires(Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DIAMOND)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', BattleItems.DIAMOND_SHARD.get())
                .unlockedBy(getHasName(BattleItems.DIAMOND_SHARD.get()), has(BattleItems.DIAMOND_SHARD.get()))
                .save(output, getItemName(Items.DIAMOND) + "_from_shards");


        // base recipes for new tiers
        swordRecipe(BattleItems.STEEL_SWORD, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        pickaxeRecipe(BattleItems.STEEL_PICKAXE, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        axeRecipe(BattleItems.STEEL_AXE, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        shovelRecipe(BattleItems.STEEL_SHOVEL, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        hoeRecipe(BattleItems.STEEL_HOE, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);

        // Weapon Recipes
        battleaxeRecipe(BattleItems.STONE_BATTLEAXE, Ingredient.of(ItemTags.STONE_CRAFTING_MATERIALS), Items.COBBLESTONE, output);
        battleaxeRecipe(BattleItems.GOLDEN_BATTLEAXE, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        battleaxeRecipe(BattleItems.IRON_BATTLEAXE, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        battleaxeRecipe(BattleItems.STEEL_BATTLEAXE, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        battleaxeRecipe(BattleItems.DIAMOND_BATTLEAXE, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_BATTLEAXE.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_BATTLEAXE.get());

        anchorRecipe(BattleItems.GOLDEN_ANCHOR, Ingredient.of(Items.GOLD_INGOT), Ingredient.of(Items.GOLD_NUGGET), Items.GOLD_INGOT, output);
        anchorRecipe(BattleItems.IRON_ANCHOR, Ingredient.of(Items.IRON_INGOT), Ingredient.of(Items.IRON_NUGGET), Items.IRON_INGOT, output);
        anchorRecipe(BattleItems.STEEL_ANCHOR, Ingredient.of(BattleItems.STEEL_INGOT), Ingredient.of(BattleItems.STEEL_NUGGET), BattleItems.STEEL_INGOT, output);
        anchorRecipe(BattleItems.DIAMOND_ANCHOR, Ingredient.of(Items.DIAMOND), Ingredient.of(BattleItems.DIAMOND_SHARD), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_ANCHOR.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_ANCHOR.get());

        hammerRecipe(BattleItems.GOLDEN_HAMMER, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        hammerRecipe(BattleItems.IRON_HAMMER, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        hammerRecipe(BattleItems.STEEL_HAMMER, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        hammerRecipe(BattleItems.DIAMOND_HAMMER, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_HAMMER.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_HAMMER.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BattleItems.WOODEN_CLUB)
                .pattern(" S ")
                .pattern("S  ")
                .define('S', Ingredient.of(ItemTags.LOGS))
                .unlockedBy(getHasName(Items.OAK_LOG), has(Items.OAK_LOG))
                .save(output, getItemName(BattleItems.WOODEN_CLUB));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BattleItems.BONE_CLUB)
                .pattern(" S ")
                .pattern("S  ")
                .define('S', Ingredient.of(Items.BONE_BLOCK))
                .unlockedBy(getHasName(Items.BONE_BLOCK), has(Items.BONE_BLOCK))
                .save(output, getItemName(BattleItems.BONE_CLUB));

        katanaRecipe(BattleItems.GOLDEN_KATANA, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        katanaRecipe(BattleItems.IRON_KATANA, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        katanaRecipe(BattleItems.STEEL_KATANA, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        katanaRecipe(BattleItems.DIAMOND_KATANA, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_KATANA.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_KATANA.get());

        rapierRecipe(BattleItems.GOLDEN_RAPIER, Ingredient.of(Items.GOLD_INGOT), Ingredient.of(Items.GOLD_NUGGET), Items.GOLD_INGOT, output);
        rapierRecipe(BattleItems.IRON_RAPIER, Ingredient.of(Items.IRON_INGOT), Ingredient.of(Items.IRON_NUGGET), Items.IRON_INGOT, output);
        rapierRecipe(BattleItems.STEEL_RAPIER, Ingredient.of(BattleItems.STEEL_INGOT), Ingredient.of(BattleItems.STEEL_NUGGET), BattleItems.STEEL_INGOT, output);
        rapierRecipe(BattleItems.DIAMOND_RAPIER, Ingredient.of(Items.DIAMOND), Ingredient.of(BattleItems.DIAMOND_SHARD), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_RAPIER.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_RAPIER.get());

        cutlassRecipe(BattleItems.WOODEN_CUTLASS, Ingredient.of(ItemTags.PLANKS), Ingredient.of(ItemTags.PLANKS), Items.OAK_PLANKS, output);
        cutlassRecipe(BattleItems.GOLDEN_CUTLASS, Ingredient.of(Items.GOLD_INGOT), Ingredient.of(Items.GOLD_NUGGET), Items.GOLD_INGOT, output);
        cutlassRecipe(BattleItems.IRON_CUTLASS, Ingredient.of(Items.IRON_INGOT), Ingredient.of(Items.IRON_NUGGET), Items.IRON_INGOT, output);
        cutlassRecipe(BattleItems.STEEL_CUTLASS, Ingredient.of(BattleItems.STEEL_INGOT), Ingredient.of(BattleItems.STEEL_NUGGET), BattleItems.STEEL_INGOT, output);
        cutlassRecipe(BattleItems.DIAMOND_CUTLASS, Ingredient.of(Items.DIAMOND), Ingredient.of(BattleItems.DIAMOND_SHARD), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_CUTLASS.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_CUTLASS.get());

        daggerRecipe(BattleItems.FLINT_DAGGER, Ingredient.of(Items.FLINT), Items.FLINT, output);
        daggerRecipe(BattleItems.BONE_DAGGER, Ingredient.of(Items.BONE), Items.BONE, output);
        daggerRecipe(BattleItems.GOLDEN_DAGGER, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        daggerRecipe(BattleItems.IRON_DAGGER, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        daggerRecipe(BattleItems.STEEL_DAGGER, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        daggerRecipe(BattleItems.DIAMOND_DAGGER, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_DAGGER.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_DAGGER.get());

        greatswordRecipe(BattleItems.STONE_GREATSWORD, Ingredient.of(ItemTags.STONE_CRAFTING_MATERIALS), Items.COBBLESTONE, output);
        greatswordRecipe(BattleItems.GOLDEN_GREATSWORD, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        greatswordRecipe(BattleItems.IRON_GREATSWORD, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        greatswordRecipe(BattleItems.STEEL_GREATSWORD, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        greatswordRecipe(BattleItems.DIAMOND_GREATSWORD, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_GREATSWORD.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_GREATSWORD.get());

        clawRecipe(BattleItems.FLINT_CLAW, Ingredient.of(Items.FLINT), Items.FLINT, output);
        clawRecipe(BattleItems.GOLDEN_CLAW, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        clawRecipe(BattleItems.IRON_CLAW, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        clawRecipe(BattleItems.STEEL_CLAW, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        clawRecipe(BattleItems.DIAMOND_CLAW, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_CLAW.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_CLAW.get());

        sickleRecipe(BattleItems.GOLDEN_SICKLE, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        sickleRecipe(BattleItems.IRON_SICKLE, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        sickleRecipe(BattleItems.STEEL_SICKLE, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        sickleRecipe(BattleItems.DIAMOND_SICKLE, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_SICKLE.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_SICKLE.get());

        spearRecipe(BattleItems.FLINT_SPEAR, Ingredient.of(Items.FLINT), Items.FLINT, output);
        spearRecipe(BattleItems.GOLDEN_SPEAR, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        spearRecipe(BattleItems.IRON_SPEAR, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        spearRecipe(BattleItems.STEEL_SPEAR, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        spearRecipe(BattleItems.DIAMOND_SPEAR, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_SPEAR.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_SPEAR.get());

        quarterstaffRecipe(BattleItems.WOODEN_QUARTERSTAFF, Ingredient.of(ItemTags.PLANKS), Items.OAK_PLANKS, output);
        quarterstaffRecipe(BattleItems.GOLDEN_QUARTERSTAFF, Ingredient.of(Items.GOLD_NUGGET), Items.GOLD_NUGGET, output);
        quarterstaffRecipe(BattleItems.IRON_QUARTERSTAFF, Ingredient.of(Items.IRON_NUGGET), Items.IRON_NUGGET, output);
        quarterstaffRecipe(BattleItems.STEEL_QUARTERSTAFF, Ingredient.of(BattleItems.STEEL_NUGGET), BattleItems.STEEL_NUGGET, output);
        quarterstaffRecipe(BattleItems.DIAMOND_QUARTERSTAFF, Ingredient.of(BattleItems.DIAMOND_SHARD), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_QUARTERSTAFF.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_QUARTERSTAFF.get());

        glaiveRecipe(BattleItems.STONE_GLAIVE, Ingredient.of(ItemTags.STONE_CRAFTING_MATERIALS), Ingredient.of(ItemTags.STONE_CRAFTING_MATERIALS), Items.COBBLESTONE, output);
        glaiveRecipe(BattleItems.GOLDEN_GLAIVE, Ingredient.of(Items.GOLD_INGOT), Ingredient.of(Items.GOLD_NUGGET), Items.GOLD_INGOT, output);
        glaiveRecipe(BattleItems.IRON_GLAIVE, Ingredient.of(Items.IRON_INGOT),Ingredient.of(Items.IRON_NUGGET), Items.IRON_INGOT, output);
        glaiveRecipe(BattleItems.STEEL_GLAIVE, Ingredient.of(BattleItems.STEEL_INGOT),Ingredient.of(BattleItems.STEEL_NUGGET), BattleItems.STEEL_INGOT, output);
        glaiveRecipe(BattleItems.DIAMOND_GLAIVE, Ingredient.of(BattleItems.DIAMOND_GLAIVE),Ingredient.of(BattleItems.DIAMOND_SHARD), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_GLAIVE.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_GLAIVE.get());

        scytheRecipe(BattleItems.WOODEN_SCYTHE, Ingredient.of(ItemTags.PLANKS), Items.OAK_PLANKS, output);
        scytheRecipe(BattleItems.GOLDEN_SCYTHE, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        scytheRecipe(BattleItems.IRON_SCYTHE, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        scytheRecipe(BattleItems.STEEL_SCYTHE, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        scytheRecipe(BattleItems.DIAMOND_SCYTHE, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_SCYTHE.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_SCYTHE.get());

        javelinRecipe(BattleItems.FLINT_JAVELIN, Ingredient.of(Items.FLINT), Ingredient.of(Items.FLINT), Items.FLINT, output);
        javelinRecipe(BattleItems.GOLDEN_JAVELIN, Ingredient.of(Items.GOLD_INGOT), Ingredient.of(Items.GOLD_NUGGET), Items.GOLD_INGOT, output);
        javelinRecipe(BattleItems.IRON_JAVELIN, Ingredient.of(Items.IRON_INGOT), Ingredient.of(Items.IRON_NUGGET), Items.IRON_INGOT, output);
        javelinRecipe(BattleItems.STEEL_JAVELIN, Ingredient.of(BattleItems.STEEL_INGOT), Ingredient.of(BattleItems.STEEL_NUGGET), BattleItems.STEEL_INGOT, output);
        javelinRecipe(BattleItems.DIAMOND_JAVELIN, Ingredient.of(Items.DIAMOND), Ingredient.of(BattleItems.DIAMOND_SHARD), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_JAVELIN.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_JAVELIN.get());

        boomerangRecipe(BattleItems.WOODEN_BOOMERANG, Ingredient.of(ItemTags.PLANKS), Items.OAK_PLANKS, output);
        boomerangRecipe(BattleItems.GOLDEN_BOOMERANG, Ingredient.of(Items.GOLD_INGOT), Items.GOLD_INGOT, output);
        boomerangRecipe(BattleItems.IRON_BOOMERANG, Ingredient.of(Items.IRON_INGOT), Items.IRON_INGOT, output);
        boomerangRecipe(BattleItems.STEEL_BOOMERANG, Ingredient.of(BattleItems.STEEL_INGOT), BattleItems.STEEL_INGOT, output);
        boomerangRecipe(BattleItems.DIAMOND_BOOMERANG, Ingredient.of(Items.DIAMOND), Items.DIAMOND, output);
        netheriteSmithing(output, BattleItems.DIAMOND_BOOMERANG.get(), RecipeCategory.COMBAT, BattleItems.NETHERITE_BOOMERANG.get());

        // other recipes
    }

    public static void smokingRecipe(RecipeOutput output,  List<ItemLike> pIngredients,  RecipeCategory pCategory,  ItemLike pResult,  float pExperience,  int cookingTime,  String pGroup) {
        oreCooking(output, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult, pExperience, cookingTime, pGroup, "_from_smoking");
    }

    public static void campfireRecipe(RecipeOutput output, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(output, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_camp_fire");
    }

    // Weapon Recipes
    public static void daggerRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  S")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void greatswordRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" S ")
                .pattern("S|S")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void katanaRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  S")
                .pattern(" S ")
                .pattern("|  ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void rapierRecipe(ItemLike result, Ingredient ingot, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  S")
                .pattern("sS ")
                .pattern("|s ")
                .define('S', ingot)
                .define('s', nugget)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void cutlassRecipe(ItemLike result, Ingredient ingot, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" |s")
                .define('S', ingot)
                .define('s', nugget)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void sickleRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern("SS ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void clawRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SS ")
                .pattern("SS ")
                .pattern("LL ")
                .define('S', ingot)
                .define('L', Items.LEATHER)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void hammerRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S|S")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void anchorRecipe(ItemLike result, Ingredient ingot, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S|S")
                .pattern("s|s")
                .define('S', ingot)
                .define('s', nugget)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void battleaxeRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("S|S")
                .pattern("S|S")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void spearRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  S")
                .pattern(" | ")
                .pattern("|  ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void javelinRecipe(ItemLike result, Ingredient ingot, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  S")
                .pattern(" | ")
                .pattern("s  ")
                .define('S', ingot)
                .define('s', nugget)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void quarterstaffRecipe(ItemLike result, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  s")
                .pattern(" | ")
                .pattern("s  ")
                .define('s', nugget)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void glaiveRecipe(ItemLike result, Ingredient ingot, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" sS")
                .pattern(" | ")
                .pattern("|  ")
                .define('S', ingot)
                .define('s', nugget)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void scytheRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern(" | ")
                .pattern("|  ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void boomerangRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("|SS")
                .pattern("S  ")
                .pattern("S  ")
                .define('S', ingot)
                .define('|', Items.LEATHER)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void kunaiRecipe(ItemLike result, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  s")
                .pattern(" | ")
                .define('s', nugget)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void swordRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void pickaxeRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern(" | ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void axeRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SS ")
                .pattern("S| ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void shovelRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" | ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void hoeRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SS ")
                .pattern(" | ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void helmetRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S S")
                .define('S', ingot)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void chestplateRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ingot)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void leggingsRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ingot)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void bootsRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("S S")
                .pattern("S S")
                .define('S', ingot)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
}
