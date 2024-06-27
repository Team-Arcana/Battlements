package net.teamarcana.battlements.init;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.trait.ParryingTrait;
import net.teamarcana.battlements.api.trait.ThrowableTrait;
import net.teamarcana.battlements.api.trait.Trait;
import net.teamarcana.battlements.api.trait.VersatileTrait;
import java.util.function.Supplier;

@EventBusSubscriber(modid = Battlements.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BattleTraits {
    public static final ResourceLocation REGISTRY_LOCATION = ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "trait");
    public static final ResourceKey<Registry<Trait>> REGISTRY_KEY = ResourceKey.createRegistryKey(REGISTRY_LOCATION);
    public static final Registry<Trait> REGISTRY = new RegistryBuilder<>(REGISTRY_KEY).create();
    public static final DeferredRegister<Trait> TRAITS = DeferredRegister.create(REGISTRY_KEY, Battlements.MOD_ID);

    public static final String POSITIVE = "positive";
    public static final String NEUTRAL = "neutral";
    public static final String NEGATIVE = "negative";


    // the traits
    public static final Supplier<Trait> THROWABLE = TRAITS.register("throwable", ()->
            new ThrowableTrait(BattleTraitTypes.THROWABLE, Battlements.MOD_ID, POSITIVE).setMelee().setAction());
    public static final Supplier<Trait> PARRYING = TRAITS.register("parrying", ()->
            new ParryingTrait(BattleTraitTypes.PARRYING, Battlements.MOD_ID, POSITIVE).setMelee().setAction());

    public static final Supplier<Trait> SHIELD_BREACH = TRAITS.register("shield_breach", ()->
            new Trait(BattleTraitTypes.SHIELD_BREACH, Battlements.MOD_ID, POSITIVE).setMelee()
    );

    public static final Supplier<Trait> VERSATILE_PICKAXE = TRAITS.register("versatile_pickaxe", () ->
            new VersatileTrait(BattleTraitTypes.VERSATILE, Battlements.MOD_ID, BlockTags.MINEABLE_WITH_PICKAXE, "pickaxe").setMelee());
    public static final Supplier<Trait> VERSATILE_AXE = TRAITS.register("versatile_axe", () ->
            new VersatileTrait(BattleTraitTypes.VERSATILE, Battlements.MOD_ID, BlockTags.MINEABLE_WITH_AXE, "axe").setMelee());
    public static final Supplier<Trait> VERSATILE_SHOVEL = TRAITS.register("versatile_shovel", () ->
            new VersatileTrait(BattleTraitTypes.VERSATILE, Battlements.MOD_ID, BlockTags.MINEABLE_WITH_SHOVEL, "shovel").setMelee());
	public static final Supplier<Trait> VERSATILE_HOE = TRAITS.register("versatile_hoe", () ->
            new VersatileTrait(BattleTraitTypes.VERSATILE, Battlements.MOD_ID, BlockTags.MINEABLE_WITH_HOE, "hoe").setMelee());

    // methods
    public static void register(IEventBus eventBus){
        TRAITS.register(eventBus);
    }

    @SubscribeEvent
    public static void registerRegistry(NewRegistryEvent event) {
        Battlements.LOGGER.debug("BattleTraits.registerRegistry");
        event.register(REGISTRY);
    }
}
