package net.teamarcana.battlements.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
public class BattleTiers {
    public static final Tier STEEL;
    public static final Tier FLINT;
    public static final Tier BONE;

    static{
        STEEL = new SimpleTier(
                BattleTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
                750, 7f, 2.5f, 15,
                () -> Ingredient.of(BattleItems.STEEL_INGOT.get())
        );
        FLINT = new SimpleTier(
                BlockTags.INCORRECT_FOR_WOODEN_TOOL,
                80, 3.8f, 0.8f, 5,
                () -> Ingredient.of(Items.FLINT)
        );
        BONE = new SimpleTier(
                BlockTags.INCORRECT_FOR_STONE_TOOL,
                150, 4.2f, 1.2f, 5,
                () -> Ingredient.of(Items.BONE)
        );
    }
}
