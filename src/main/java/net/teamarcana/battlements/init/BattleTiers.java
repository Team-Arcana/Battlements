package net.teamarcana.battlements.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
public class BattleTiers {
    public static final Tier STEEL;
    public static final Tier ENDERIUM;

    static{
        STEEL = new SimpleTier(
                BattleTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
                750, 7f, 2.5f, 15,
                () -> Ingredient.of(BattleItems.STEEL_INGOT.get())
        );
        ENDERIUM = new SimpleTier(
                BattleTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL,
               2031, 9.0F, 4.0F, 16,
                () -> Ingredient.of(BattleItems.ENDERIUM_INGOT.get())
        );
    }
}
