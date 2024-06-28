package net.teamarcana.battlements.init;
import net.minecraft.tags.BlockTags;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.trait.*;

import java.util.function.Supplier;

import static net.teamarcana.battlements.Battlements.MOD_ID;

public class BattleTraits {
    public static final DeferredRegister<Trait> TRAITS = DeferredRegister.create(Battlements.TRAIT_REGISTRY, MOD_ID);

    public static final String POSITIVE = "positive";
    public static final String NEUTRAL = "neutral";
    public static final String NEGATIVE = "negative";


    // the traits
    public static final Supplier<Trait> THROWABLE = TRAITS.register("throwable", ()->
            new ThrowableTrait(BattleTraitTypes.THROWABLE, MOD_ID, POSITIVE).setMelee().setAction());
    public static final Supplier<Trait> PARRYING = TRAITS.register("parrying", ()->
            new ParryingTrait(BattleTraitTypes.PARRYING, MOD_ID, POSITIVE).setMelee().setAction());

    public static final Supplier<Trait> SHIELD_BREACH = TRAITS.register("shield_breach", ()->
            new Trait(BattleTraitTypes.SHIELD_BREACH, MOD_ID, POSITIVE).setMelee()
    );

    public static final Supplier<Trait> VERSATILE_PICKAXE = TRAITS.register("versatile_pickaxe", () ->
            new VersatileTrait(BattleTraitTypes.VERSATILE, MOD_ID, BlockTags.MINEABLE_WITH_PICKAXE, "pickaxe").setMelee());
    public static final Supplier<Trait> VERSATILE_AXE = TRAITS.register("versatile_axe", () ->
            new VersatileTrait(BattleTraitTypes.VERSATILE, MOD_ID, BlockTags.MINEABLE_WITH_AXE, "axe").setMelee());
    public static final Supplier<Trait> VERSATILE_SHOVEL = TRAITS.register("versatile_shovel", ()->
            new VersatileTrait(BattleTraitTypes.VERSATILE, MOD_ID, BlockTags.MINEABLE_WITH_SHOVEL, "shovel").setMelee());
	public static final Supplier<Trait> VERSATILE_HOE = TRAITS.register("versatile_hoe", () ->
            new VersatileTrait(BattleTraitTypes.VERSATILE, MOD_ID, BlockTags.MINEABLE_WITH_HOE, "hoe").setMelee());

    // methods
    public static void register(IEventBus eventBus){
        TRAITS.register(eventBus);
    }
}
