package net.teamarcana.battlements.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
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

    // ingredients to make my life easier
    private final List<Ingredient> WOODEN_INGREDIENTS = List.of(Ingredient.of(ItemTags.PLANKS), Ingredient.of(ItemTags.WOODEN_BUTTONS));
    private final List<Ingredient> STONE_INGREDIENTS = List.of(Ingredient.of(ItemTags.STONE_CRAFTING_MATERIALS), Ingredient.of(BattleItems.ROCK));
    private final List<Ingredient> COPPER_INGREDIENTS = List.of(Ingredient.of(Items.COPPER_INGOT), Ingredient.of(BattleItems.COPPER_NUGGET.get()));
    private final List<Ingredient> GOLD_INGREDIENTS = List.of(Ingredient.of(Items.GOLD_INGOT), Ingredient.of(Items.GOLD_NUGGET));
    private final List<Ingredient> IRON_INGREDIENTS = List.of(Ingredient.of(Items.IRON_INGOT), Ingredient.of(Items.IRON_NUGGET));
    private final List<Ingredient> STEEL_INGREDIENTS = List.of(Ingredient.of(BattleItems.STEEL_INGOT.get()), Ingredient.of(BattleItems.STEEL_NUGGET.get()));
    private final List<Ingredient> DIAMOND_INGREDIENTS = List.of(Ingredient.of(Items.DIAMOND), Ingredient.of(BattleItems.DIAMOND_SHARD.get()));
    private final List<Ingredient> NETHERITE_INGREDIENTS = List.of(Ingredient.of(Items.NETHERITE_INGOT), Ingredient.of(BattleItems.NETHERITE_NUGGET.get()));
    private final List<Ingredient> ENDERIUM_INGREDIENTS = List.of(Ingredient.of(BattleItems.ENDERIUM_INGOT), Ingredient.of(BattleItems.ENDERIUM_NUGGET.get()));

    private List<ItemLike> WOODEN_WEAPONS = List.of(BattleItems.WOODEN_DAGGER, BattleItems.WOODEN_LONGSWORD, BattleItems.WOODEN_GREATSWORD, BattleItems.WOODEN_KATANA, BattleItems.WOODEN_RAPIER, BattleItems.WOODEN_SABER, BattleItems.WOODEN_CUTLASS, BattleItems.WOODEN_SICKLE, BattleItems.WOODEN_CLAW, BattleItems.WOODEN_CLUB, BattleItems.WOODEN_GREATCLUB, BattleItems.WOODEN_HAMMER, BattleItems.WOODEN_WARHAMMER, BattleItems.WOODEN_MAUL, BattleItems.WOODEN_ANCHOR, BattleItems.WOODEN_WARPICK, BattleItems.WOODEN_BATTLEAXE, BattleItems.WOODEN_GREATAXE, BattleItems.WOODEN_HALBERD, BattleItems.WOODEN_SPEAR, BattleItems.WOODEN_PIKE, BattleItems.WOODEN_QUARTERSTAFF, BattleItems.WOODEN_PITCHFORK, BattleItems.WOODEN_GLAIVE, BattleItems.WOODEN_SCYTHE, BattleItems.WOODEN_JAVELIN, BattleItems.WOODEN_BOOMERANG);
    private List<ItemLike> STONE_WEAPONS = List.of(BattleItems.STONE_DAGGER, BattleItems.STONE_LONGSWORD, BattleItems.STONE_GREATSWORD, BattleItems.STONE_KATANA, BattleItems.STONE_RAPIER, BattleItems.STONE_SABER, BattleItems.STONE_CUTLASS, BattleItems.STONE_SICKLE, BattleItems.STONE_CLAW, BattleItems.STONE_CLUB, BattleItems.STONE_GREATCLUB, BattleItems.STONE_HAMMER, BattleItems.STONE_WARHAMMER, BattleItems.STONE_MAUL, BattleItems.STONE_ANCHOR, BattleItems.STONE_WARPICK, BattleItems.STONE_BATTLEAXE, BattleItems.STONE_GREATAXE, BattleItems.STONE_HALBERD, BattleItems.STONE_SPEAR, BattleItems.STONE_PIKE, BattleItems.STONE_QUARTERSTAFF, BattleItems.STONE_PITCHFORK, BattleItems.STONE_GLAIVE, BattleItems.STONE_SCYTHE, BattleItems.STONE_JAVELIN, BattleItems.STONE_BOOMERANG);
    private List<ItemLike> GOLDEN_WEAPONS = List.of(BattleItems.GOLDEN_DAGGER, BattleItems.GOLDEN_LONGSWORD, BattleItems.GOLDEN_GREATSWORD, BattleItems.GOLDEN_KATANA, BattleItems.GOLDEN_RAPIER, BattleItems.GOLDEN_SABER, BattleItems.GOLDEN_CUTLASS, BattleItems.GOLDEN_SICKLE, BattleItems.GOLDEN_CLAW, BattleItems.GOLDEN_CLUB, BattleItems.GOLDEN_GREATCLUB, BattleItems.GOLDEN_HAMMER, BattleItems.GOLDEN_WARHAMMER, BattleItems.GOLDEN_MAUL, BattleItems.GOLDEN_ANCHOR, BattleItems.GOLDEN_WARPICK, BattleItems.GOLDEN_BATTLEAXE, BattleItems.GOLDEN_GREATAXE, BattleItems.GOLDEN_HALBERD, BattleItems.GOLDEN_SPEAR, BattleItems.GOLDEN_PIKE, BattleItems.GOLDEN_QUARTERSTAFF, BattleItems.GOLDEN_PITCHFORK, BattleItems.GOLDEN_GLAIVE, BattleItems.GOLDEN_SCYTHE, BattleItems.GOLDEN_JAVELIN, BattleItems.GOLDEN_BOOMERANG);
    private List<ItemLike> IRON_WEAPONS = List.of(BattleItems.IRON_DAGGER, BattleItems.IRON_LONGSWORD, BattleItems.IRON_GREATSWORD, BattleItems.IRON_KATANA, BattleItems.IRON_RAPIER, BattleItems.IRON_SABER, BattleItems.IRON_CUTLASS, BattleItems.IRON_SICKLE, BattleItems.IRON_CLAW, BattleItems.IRON_CLUB, BattleItems.IRON_GREATCLUB, BattleItems.IRON_HAMMER, BattleItems.IRON_WARHAMMER, BattleItems.IRON_MAUL, BattleItems.IRON_ANCHOR, BattleItems.IRON_WARPICK, BattleItems.IRON_BATTLEAXE, BattleItems.IRON_GREATAXE, BattleItems.IRON_HALBERD, BattleItems.IRON_SPEAR, BattleItems.IRON_PIKE, BattleItems.IRON_QUARTERSTAFF, BattleItems.IRON_PITCHFORK, BattleItems.IRON_GLAIVE, BattleItems.IRON_SCYTHE, BattleItems.IRON_JAVELIN, BattleItems.IRON_BOOMERANG);
    private List<ItemLike> STEEL_WEAPONS = List.of(BattleItems.STEEL_DAGGER, BattleItems.STEEL_LONGSWORD, BattleItems.STEEL_GREATSWORD, BattleItems.STEEL_KATANA, BattleItems.STEEL_RAPIER, BattleItems.STEEL_SABER, BattleItems.STEEL_CUTLASS, BattleItems.STEEL_SICKLE, BattleItems.STEEL_CLAW, BattleItems.STEEL_CLUB, BattleItems.STEEL_GREATCLUB, BattleItems.STEEL_HAMMER, BattleItems.STEEL_WARHAMMER, BattleItems.STEEL_MAUL, BattleItems.STEEL_ANCHOR, BattleItems.STEEL_WARPICK, BattleItems.STEEL_BATTLEAXE, BattleItems.STEEL_GREATAXE, BattleItems.STEEL_HALBERD, BattleItems.STEEL_SPEAR, BattleItems.STEEL_PIKE, BattleItems.STEEL_QUARTERSTAFF, BattleItems.STEEL_PITCHFORK, BattleItems.STEEL_GLAIVE, BattleItems.STEEL_SCYTHE, BattleItems.STEEL_JAVELIN, BattleItems.STEEL_BOOMERANG);
    private List<ItemLike> DIAMOND_WEAPONS = List.of(BattleItems.DIAMOND_DAGGER, BattleItems.DIAMOND_LONGSWORD, BattleItems.DIAMOND_GREATSWORD, BattleItems.DIAMOND_KATANA, BattleItems.DIAMOND_RAPIER, BattleItems.DIAMOND_SABER, BattleItems.DIAMOND_CUTLASS, BattleItems.DIAMOND_SICKLE, BattleItems.DIAMOND_CLAW, BattleItems.DIAMOND_CLUB, BattleItems.DIAMOND_GREATCLUB, BattleItems.DIAMOND_HAMMER, BattleItems.DIAMOND_WARHAMMER, BattleItems.DIAMOND_MAUL, BattleItems.DIAMOND_ANCHOR, BattleItems.DIAMOND_WARPICK, BattleItems.DIAMOND_BATTLEAXE, BattleItems.DIAMOND_GREATAXE, BattleItems.DIAMOND_HALBERD, BattleItems.DIAMOND_SPEAR, BattleItems.DIAMOND_PIKE, BattleItems.DIAMOND_QUARTERSTAFF, BattleItems.DIAMOND_PITCHFORK, BattleItems.DIAMOND_GLAIVE, BattleItems.DIAMOND_SCYTHE, BattleItems.DIAMOND_JAVELIN, BattleItems.DIAMOND_BOOMERANG);
    private List<ItemLike> NETHERITE_WEAPONS = List.of(BattleItems.NETHERITE_DAGGER, BattleItems.NETHERITE_LONGSWORD, BattleItems.NETHERITE_GREATSWORD, BattleItems.NETHERITE_KATANA, BattleItems.NETHERITE_RAPIER, BattleItems.NETHERITE_SABER, BattleItems.NETHERITE_CUTLASS, BattleItems.NETHERITE_SICKLE, BattleItems.NETHERITE_CLAW, BattleItems.NETHERITE_CLUB, BattleItems.NETHERITE_GREATCLUB, BattleItems.NETHERITE_HAMMER, BattleItems.NETHERITE_WARHAMMER, BattleItems.NETHERITE_MAUL, BattleItems.NETHERITE_ANCHOR, BattleItems.NETHERITE_WARPICK, BattleItems.NETHERITE_BATTLEAXE, BattleItems.NETHERITE_GREATAXE, BattleItems.NETHERITE_HALBERD, BattleItems.NETHERITE_SPEAR, BattleItems.NETHERITE_PIKE, BattleItems.NETHERITE_QUARTERSTAFF, BattleItems.NETHERITE_PITCHFORK, BattleItems.NETHERITE_GLAIVE, BattleItems.NETHERITE_SCYTHE, BattleItems.NETHERITE_JAVELIN, BattleItems.NETHERITE_BOOMERANG);
    private List<ItemLike> ENDERIUM_WEAPONS = List.of(BattleItems.ENDERIUM_DAGGER, BattleItems.ENDERIUM_LONGSWORD, BattleItems.ENDERIUM_GREATSWORD, BattleItems.ENDERIUM_KATANA, BattleItems.ENDERIUM_RAPIER, BattleItems.ENDERIUM_SABER, BattleItems.ENDERIUM_CUTLASS, BattleItems.ENDERIUM_SICKLE, BattleItems.ENDERIUM_CLAW, BattleItems.ENDERIUM_CLUB, BattleItems.ENDERIUM_GREATCLUB, BattleItems.ENDERIUM_HAMMER, BattleItems.ENDERIUM_WARHAMMER, BattleItems.ENDERIUM_MAUL, BattleItems.ENDERIUM_ANCHOR, BattleItems.ENDERIUM_WARPICK, BattleItems.ENDERIUM_BATTLEAXE, BattleItems.ENDERIUM_GREATAXE, BattleItems.ENDERIUM_HALBERD, BattleItems.ENDERIUM_SPEAR, BattleItems.ENDERIUM_PIKE, BattleItems.ENDERIUM_QUARTERSTAFF, BattleItems.ENDERIUM_PITCHFORK, BattleItems.ENDERIUM_GLAIVE, BattleItems.ENDERIUM_SCYTHE, BattleItems.ENDERIUM_JAVELIN, BattleItems.ENDERIUM_BOOMERANG);

    private List<ItemLike> WOODEN_UNLOCKS = List.of(BattleItems.HANDLE, BattleItems.HANDLE);
    private List<ItemLike> STONE_UNLOCKS = List.of(BattleItems.ROCK, BattleItems.ROCK);
    private List<ItemLike> GOLDEN_UNLOCKS = List.of(Items.GOLD_INGOT, Items.GOLD_NUGGET);
    private List<ItemLike> IRON_UNLOCKS = List.of(Items.IRON_INGOT, Items.IRON_NUGGET);
    private List<ItemLike> STEEL_UNLOCKS = List.of(BattleItems.STEEL_INGOT, BattleItems.STEEL_NUGGET);
    private List<ItemLike> DIAMOND_UNLOCKS = List.of(Items.DIAMOND, BattleItems.DIAMOND_SHARD);
    private List<ItemLike> NETHERITE_UNLOCKS = List.of(Items.NETHERITE_INGOT, BattleItems.NETHERITE_NUGGET);
    private List<ItemLike> ENDERIUM_UNLOCKS = List.of(BattleItems.ENDERIUM_INGOT, BattleItems.ENDERIUM_NUGGET);


    public BattleRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        oreSmelting(output, LEATHER_COOKABLES, RecipeCategory.MISC, Items.LEATHER, 0.25f, 100, "leather");
        smokingRecipe(output, LEATHER_COOKABLES, RecipeCategory.MISC, Items.LEATHER, 0.25f, 100, "leather");
        campfireRecipe(output, LEATHER_COOKABLES, RecipeCategory.MISC, Items.LEATHER, 0.25f, 100, "leather");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.HANDLE.get())
                .requires(Items.STICK)
                .requires(Items.STRING)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.ROCK.get(), 9)
                .requires(ItemTags.STONE_CRAFTING_MATERIALS)
                .unlockedBy(getHasName(BattleItems.ROCK), has(BattleItems.ROCK))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.COBBLESTONE)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', BattleItems.ROCK)
                .unlockedBy(getHasName(BattleItems.ROCK), has(BattleItems.ROCK))
                .save(output, getItemName(Blocks.COBBLESTONE) + "_from_rocks");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.HANDLE.get(), 4)
                .requires(Items.STICK, 4)
                .requires(Items.LEATHER)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output, getItemName(BattleItems.HANDLE.get()) + "_from_leather");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BattleItems.POLE.get())
                .pattern("S")
                .pattern("-")
                .pattern("S")
                .define('S', Items.STICK)
                .define('-', Items.STRING)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.POLE.get(), 4)
                .requires(Items.STICK, 8)
                .requires(Items.LEATHER)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output, getItemName(BattleItems.POLE.get()) + "_from_leather");

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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.ENDERIUM_INGOT, 9)
                .requires(BattleItems.ENDERIUM_BLOCK)
                .unlockedBy(getHasName(BattleItems.ENDERIUM_BLOCK), has(BattleItems.ENDERIUM_BLOCK))
                .save(output, getItemName(BattleItems.ENDERIUM_INGOT) + "_from_block");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BattleItems.ENDERIUM_BLOCK)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', BattleItems.ENDERIUM_INGOT)
                .unlockedBy(getHasName(BattleItems.ENDERIUM_INGOT), has(BattleItems.ENDERIUM_INGOT))
                .save(output, getItemName(BattleItems.ENDERIUM_BLOCK));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BattleItems.ENDERIUM_NUGGET, 9)
                .requires(BattleItems.ENDERIUM_INGOT)
                .unlockedBy(getHasName(BattleItems.ENDERIUM_INGOT), has(BattleItems.ENDERIUM_INGOT))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BattleItems.ENDERIUM_INGOT)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', BattleItems.ENDERIUM_NUGGET)
                .unlockedBy(getHasName(BattleItems.ENDERIUM_NUGGET), has(BattleItems.ENDERIUM_NUGGET))
                .save(output, getItemName(BattleItems.ENDERIUM_INGOT) + "_from_nuggets");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BattleItems.ENDERIUM_INGOT.get())
                .pattern("EEE")
                .pattern("ESS")
                .pattern("SS ")
                .define('E', BattleItems.ENDER_CRYSTAL.get())
                .define('S', Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(BattleItems.ENDER_CRYSTAL.get()), has(BattleItems.ENDER_CRYSTAL.get()))
                .save(output, getItemName(BattleItems.ENDERIUM_INGOT.get()));

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
        swordRecipe(BattleItems.STEEL_SWORD, STEEL_INGREDIENTS.get(0), BattleItems.STEEL_INGOT, output);
        pickaxeRecipe(BattleItems.STEEL_PICKAXE, STEEL_INGREDIENTS.get(0), BattleItems.STEEL_INGOT, output);
        axeRecipe(BattleItems.STEEL_AXE, STEEL_INGREDIENTS.get(0), BattleItems.STEEL_INGOT, output);
        shovelRecipe(BattleItems.STEEL_SHOVEL, STEEL_INGREDIENTS.get(0), BattleItems.STEEL_INGOT, output);
        hoeRecipe(BattleItems.STEEL_HOE, STEEL_INGREDIENTS.get(0), BattleItems.STEEL_INGOT, output);

        netheriteSmithing(output, Items.DIAMOND_SWORD, RecipeCategory.COMBAT, BattleItems.ENDERIUM_SWORD.get());
        netheriteSmithing(output, Items.DIAMOND_PICKAXE, RecipeCategory.COMBAT, BattleItems.ENDERIUM_PICKAXE.get());
        netheriteSmithing(output, Items.DIAMOND_AXE, RecipeCategory.COMBAT, BattleItems.ENDERIUM_AXE.get());
        netheriteSmithing(output, Items.DIAMOND_SHOVEL, RecipeCategory.COMBAT, BattleItems.ENDERIUM_SHOVEL.get());
        netheriteSmithing(output, Items.DIAMOND_HOE, RecipeCategory.COMBAT, BattleItems.ENDERIUM_HOE.get());

        // New Weapon Recipes
        weaponRecipes(WOODEN_WEAPONS, WOODEN_INGREDIENTS, WOODEN_UNLOCKS, output);
        weaponRecipes(STONE_WEAPONS, STONE_INGREDIENTS, STONE_UNLOCKS, output);
        weaponRecipes(GOLDEN_WEAPONS, GOLD_INGREDIENTS, GOLDEN_UNLOCKS, output);
        weaponRecipes(IRON_WEAPONS, IRON_INGREDIENTS, IRON_UNLOCKS, output);
        weaponRecipes(STEEL_WEAPONS, STEEL_INGREDIENTS, STEEL_UNLOCKS, output);
        weaponRecipes(DIAMOND_WEAPONS, DIAMOND_INGREDIENTS, DIAMOND_UNLOCKS, output);
        for(int i = 0; i < NETHERITE_WEAPONS.size(); i++){
            netheriteSmithing(output, DIAMOND_WEAPONS.get(i).asItem(), RecipeCategory.COMBAT, NETHERITE_WEAPONS.get(i).asItem());
            netheriteSmithing(output, DIAMOND_WEAPONS.get(i).asItem(), RecipeCategory.COMBAT, ENDERIUM_WEAPONS.get(i).asItem());
        }

        // stackable ones
        kunaiRecipe(BattleItems.WOODEN_KUNAI, WOODEN_INGREDIENTS.get(1), Items.STICK, output);
        kunaiRecipe(BattleItems.STONE_KUNAI, STONE_INGREDIENTS.get(1), BattleItems.ROCK, output);
        kunaiRecipe(BattleItems.GOLDEN_KUNAI, GOLD_INGREDIENTS.get(1), Items.GOLD_INGOT, output);
        kunaiRecipe(BattleItems.IRON_KUNAI, IRON_INGREDIENTS.get(1), Items.IRON_INGOT, output);
        kunaiRecipe(BattleItems.STEEL_KUNAI, STEEL_INGREDIENTS.get(1), BattleItems.STEEL_INGOT, output);
        kunaiRecipe(BattleItems.DIAMOND_KUNAI, DIAMOND_INGREDIENTS.get(1), Items.DIAMOND, output);
        kunaiRecipe(BattleItems.NETHERITE_KUNAI, NETHERITE_INGREDIENTS.get(1), Items.NETHERITE_INGOT, output);
        kunaiRecipe(BattleItems.ENDERIUM_KUNAI, ENDERIUM_INGREDIENTS.get(1), BattleItems.ENDERIUM_INGOT, output);
        tomahawkRecipe(BattleItems.WOODEN_TOMAHAWK, WOODEN_INGREDIENTS.get(1), Items.STICK, output);
        tomahawkRecipe(BattleItems.STONE_TOMAHAWK, STONE_INGREDIENTS.get(1), BattleItems.ROCK, output);
        tomahawkRecipe(BattleItems.GOLDEN_TOMAHAWK, GOLD_INGREDIENTS.get(1), Items.GOLD_INGOT, output);
        tomahawkRecipe(BattleItems.IRON_TOMAHAWK, IRON_INGREDIENTS.get(1), Items.IRON_INGOT, output);
        tomahawkRecipe(BattleItems.STEEL_TOMAHAWK, STEEL_INGREDIENTS.get(1), BattleItems.STEEL_INGOT, output);
        tomahawkRecipe(BattleItems.DIAMOND_TOMAHAWK, DIAMOND_INGREDIENTS.get(1), Items.DIAMOND, output);
        tomahawkRecipe(BattleItems.NETHERITE_TOMAHAWK, NETHERITE_INGREDIENTS.get(1), Items.NETHERITE_INGOT, output);
        tomahawkRecipe(BattleItems.ENDERIUM_TOMAHAWK, ENDERIUM_INGREDIENTS.get(1), BattleItems.ENDERIUM_INGOT, output);
        throwingKnifeRecipe(BattleItems.WOODEN_THROWING_KNIFE, WOODEN_INGREDIENTS.get(1), Items.STICK, output);
        throwingKnifeRecipe(BattleItems.STONE_THROWING_KNIFE, STONE_INGREDIENTS.get(1), BattleItems.ROCK, output);
        throwingKnifeRecipe(BattleItems.GOLDEN_THROWING_KNIFE, GOLD_INGREDIENTS.get(1), Items.GOLD_INGOT, output);
        throwingKnifeRecipe(BattleItems.IRON_THROWING_KNIFE, IRON_INGREDIENTS.get(1), Items.IRON_INGOT, output);
        throwingKnifeRecipe(BattleItems.STEEL_THROWING_KNIFE, STEEL_INGREDIENTS.get(1), BattleItems.STEEL_INGOT, output);
        throwingKnifeRecipe(BattleItems.DIAMOND_THROWING_KNIFE, DIAMOND_INGREDIENTS.get(1), Items.DIAMOND, output);
        throwingKnifeRecipe(BattleItems.NETHERITE_THROWING_KNIFE, NETHERITE_INGREDIENTS.get(1), Items.NETHERITE_INGOT, output);
        throwingKnifeRecipe(BattleItems.ENDERIUM_THROWING_KNIFE, ENDERIUM_INGREDIENTS.get(1), BattleItems.ENDERIUM_INGOT, output);
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
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void longswordRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void greatswordRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" S ")
                .pattern("S|S")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void katanaRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  S")
                .pattern(" S ")
                .pattern("|  ")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
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
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void saberRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" |S")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
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
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void sickleRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern("SS ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
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
    public static void clubRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" SS")
                .pattern(" SS")
                .pattern("|  ")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void greatclubRecipe(ItemLike result, Ingredient ingot, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("sSS")
                .pattern("sSS")
                .pattern("|ss")
                .define('S', ingot)
                .define('s', nugget)
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void hammerRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S|S")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void warhammerRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern("SS ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void maulRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S|S")
                .define('S', ingot)
                .define('|', BattleItems.POLE)
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
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void warpickRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern(" | ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void battleaxeRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("S|S")
                .pattern("S|S")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.HANDLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void greataxeRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SS ")
                .pattern("S| ")
                .define('S', ingot)
                .define('|', BattleItems.POLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void halberdRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern("SS ")
                .pattern("S| ")
                .define('S', ingot)
                .define('|', BattleItems.POLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void spearRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.POLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void pikeRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" | ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.POLE)
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
                .define('|', BattleItems.POLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void quarterstaffRecipe(ItemLike result, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("  s")
                .pattern(" | ")
                .pattern("s  ")
                .define('s', nugget)
                .define('|', BattleItems.POLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void glaiveRecipe(ItemLike result, Ingredient ingot, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" sS")
                .pattern("  |")
                .define('S', ingot)
                .define('s', nugget)
                .define('|', BattleItems.POLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void pitchforkRecipe(ItemLike result, Ingredient ingot, Ingredient nugget, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("sss")
                .pattern(" S ")
                .pattern(" | ")
                .define('S', ingot)
                .define('s', nugget)
                .define('|', BattleItems.POLE)
                .unlockedBy(getHasName(unlockItem), has(unlockItem))
                .save(output);
    }
    public static void scytheRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SS ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', BattleItems.POLE)
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
    public static void throwingKnifeRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" S ")
                .pattern(" | ")
                .define('S', ingot)
                .define('|', Items.STICK)
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
    public static void tomahawkRecipe(ItemLike result, Ingredient ingot, ItemLike unlockItem, RecipeOutput output){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SS ")
                .pattern("S| ")
                .define('S', ingot)
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

    /**
     * Method to automatically generate recipes for a tier [Note: this is only for the base weapon types, not counting kunais, tomahawks, or throwing knives]
     * @param resultItems a list of every weapon in that tier
     * @param ingredients a list of ingredients (should have a size of 2, with index 0 being the ingot, and index 1 being the nugget)
     * @param unlockItems a list of items that unlock the recipe (should have a size of 2, with the order being: ingot, nugget)
     * @param output the recipe output
     */
    public static void weaponRecipes(List<ItemLike> resultItems, List<Ingredient> ingredients, List<ItemLike> unlockItems, RecipeOutput output){
        daggerRecipe(resultItems.get(0), ingredients.get(0), unlockItems.get(0), output);
        longswordRecipe(resultItems.get(1), ingredients.get(0), unlockItems.get(0), output);
        greatswordRecipe(resultItems.get(2), ingredients.get(0), unlockItems.get(0), output);
        katanaRecipe(resultItems.get(3), ingredients.get(0), unlockItems.get(0), output);
        rapierRecipe(resultItems.get(4), ingredients.get(0), ingredients.get(1), unlockItems.get(0), output);
        saberRecipe(resultItems.get(5), ingredients.get(0), unlockItems.get(0), output);
        cutlassRecipe(resultItems.get(6), ingredients.get(0), ingredients.get(1), unlockItems.get(0), output);
        sickleRecipe(resultItems.get(7), ingredients.get(0), unlockItems.get(0), output);
        clawRecipe(resultItems.get(8), ingredients.get(0), unlockItems.get(0), output);
        clubRecipe(resultItems.get(9), ingredients.get(0), unlockItems.get(0), output);
        greatclubRecipe(resultItems.get(10), ingredients.get(0), ingredients.get(1), unlockItems.get(0), output);
        hammerRecipe(resultItems.get(11), ingredients.get(0), unlockItems.get(0), output);
        warhammerRecipe(resultItems.get(12), ingredients.get(0), unlockItems.get(0), output);
        maulRecipe(resultItems.get(13), ingredients.get(0), unlockItems.get(0), output);
        anchorRecipe(resultItems.get(14), ingredients.get(0), ingredients.get(1), unlockItems.get(0), output);
        warpickRecipe(resultItems.get(15), ingredients.get(0), unlockItems.get(0), output);
        battleaxeRecipe(resultItems.get(16), ingredients.get(0), unlockItems.get(0), output);
        greataxeRecipe(resultItems.get(17), ingredients.get(0), unlockItems.get(0), output);
        halberdRecipe(resultItems.get(18), ingredients.get(0), unlockItems.get(0), output);
        spearRecipe(resultItems.get(19), ingredients.get(0), unlockItems.get(0), output);
        pikeRecipe(resultItems.get(20), ingredients.get(0), unlockItems.get(0), output);
        quarterstaffRecipe(resultItems.get(21), ingredients.get(1), unlockItems.get(1), output);
        pitchforkRecipe(resultItems.get(22), ingredients.get(0), ingredients.get(1), unlockItems.get(0), output);
        glaiveRecipe(resultItems.get(23), ingredients.get(0), ingredients.get(1), unlockItems.get(0), output);
        scytheRecipe(resultItems.get(24), ingredients.get(0), unlockItems.get(0), output);
        javelinRecipe(resultItems.get(25), ingredients.get(0), ingredients.get(1), unlockItems.get(0), output);
        boomerangRecipe(resultItems.get(26), ingredients.get(0), unlockItems.get(0), output);
    }
}
