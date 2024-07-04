package net.teamarcana.battlements.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;

import java.util.function.Supplier;

public class BattlePotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(Registries.POTION, Battlements.MOD_ID);

    // VOLATILE
    public static final Holder<Potion> VOLATILE = POTIONS.register("volatile", ()-> new Potion(new MobEffectInstance(BattleMobEffects.VOLATILE, 3600)));
    public static final Holder<Potion> LONG_VOLATILE = POTIONS.register("long_volatile", ()-> new Potion("volatile", new MobEffectInstance(BattleMobEffects.VOLATILE, 9600)));
    public static final Holder<Potion> STRONG_VOLATILE = POTIONS.register("strong_volatile",()-> new Potion("volatile", new MobEffectInstance(BattleMobEffects.VOLATILE, 1800, 1)));

    // TITAN
    public static final Holder<Potion> TITAN = POTIONS.register("titan", ()-> new Potion(new MobEffectInstance(BattleMobEffects.TITAN, 3600)));
    public static final Holder<Potion> LONG_TITAN = POTIONS.register("long_titan",()-> new Potion("titan", new MobEffectInstance(BattleMobEffects.TITAN, 9600)));
    public static final Holder<Potion> STRONG_TITAN = POTIONS.register("strong_titan",()-> new Potion("titan", new MobEffectInstance(BattleMobEffects.TITAN, 1800, 1)));

    // TINY
    public static final Holder<Potion> TINY = POTIONS.register("tiny",()-> new Potion(new MobEffectInstance(BattleMobEffects.TINY, 3600)));
    public static final Holder<Potion> LONG_TINY = POTIONS.register("long_tiny",()-> new Potion("tiny", new MobEffectInstance(BattleMobEffects.TINY, 9600)));
    public static final Holder<Potion> STRONG_TINY = POTIONS.register("strong_tiny",()-> new Potion("tiny", new MobEffectInstance(BattleMobEffects.TINY, 1800, 1)));

    // BROKEN_ARMOR
    public static final Holder<Potion> BROKEN_ARMOR = POTIONS.register("broken_armor",()-> new Potion(new MobEffectInstance(BattleMobEffects.BROKEN_ARMOR, 3600)));
    public static final Holder<Potion> LONG_BROKEN_ARMOR = POTIONS.register("long_broken_armor",()-> new Potion("broken_armor", new MobEffectInstance(BattleMobEffects.BROKEN_ARMOR, 9600)));
    public static final Holder<Potion> STRONG_BROKEN_ARMOR = POTIONS.register("strong_broken_armor",()-> new Potion("broken_armor", new MobEffectInstance(BattleMobEffects.BROKEN_ARMOR, 1800, 1)));

    // KNOCKBACK_BOOST
    public static final Holder<Potion> KNOCKBACK_BOOST = POTIONS.register("slamming",()-> new Potion(new MobEffectInstance(BattleMobEffects.KNOCKBACK_BOOST, 3600)));
    public static final Holder<Potion> LONG_KNOCKBACK_BOOST = POTIONS.register("long_slamming",()-> new Potion("slamming", new MobEffectInstance(BattleMobEffects.KNOCKBACK_BOOST, 9600)));
    public static final Holder<Potion> STRONG_KNOCKBACK_BOOST = POTIONS.register("strong_slamming",()-> new Potion("slamming", new MobEffectInstance(BattleMobEffects.KNOCKBACK_BOOST, 1800, 1)));

    public static void register(IEventBus eventBus){
       POTIONS.register(eventBus);
    }
}
