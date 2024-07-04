package net.teamarcana.battlements.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.mob_effects.BattleMobEffect;
import net.teamarcana.battlements.mob_effects.ExplodingMobEffect;

import java.util.function.Supplier;

public class BattleMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, Battlements.MOD_ID);

    /*
    public static Supplier<MobEffect> BLEEDING = MOB_EFFECTS.register("bleeding", BleedEffect::new);
    public static Supplier<MobEffect> STUNNED = MOB_EFFECTS.register("stunned", StunEffect::new);
     */

    public static final Holder<MobEffect> ENCUMBERED = MOB_EFFECTS.register("encumbered",()->
            new BattleMobEffect(MobEffectCategory.HARMFUL, 0x575454)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.encumbered"),
                            -4.0, AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.ATTACK_SPEED,
                            ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.encumbered"),
                            -0.1F, AttributeModifier.Operation.ADD_VALUE)
    );


    public static final Holder<MobEffect> BROKEN_ARMOR = MOB_EFFECTS.register("broken_armor",()->
            new BattleMobEffect(MobEffectCategory.HARMFUL, 0x424650)
                    .addAttributeModifier(Attributes.ARMOR,
                            ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.broken_armor"),
                            -3.0, AttributeModifier.Operation.ADD_VALUE)
    );
    public static final Holder<MobEffect> TITAN = MOB_EFFECTS.register("titan",()-> new BattleMobEffect(MobEffectCategory.BENEFICIAL, 0x4aa0ce)
            .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.titan"), 0.5d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.titan"), 0.5d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.titan"), 0.5d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.titan"), 2.0, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.titan"), 1.5d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.titan"), 1.5d, AttributeModifier.Operation.ADD_VALUE)
    );
    public static final Holder<MobEffect> TINY = MOB_EFFECTS.register("tiny",()-> new BattleMobEffect(MobEffectCategory.HARMFUL, 0xce4a4a)
            .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.tiny"), -0.5d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.titan"), -0.5d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.titan"), -0.5d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.tiny"), -2.0, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.tiny"), -1.5d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.tiny"), -1.5d, AttributeModifier.Operation.ADD_VALUE)
    );
    // a terrible case of the explosions
    public static final Holder<MobEffect> VOLATILE = MOB_EFFECTS.register("volatile", ()->  new ExplodingMobEffect());

    public static final Holder<MobEffect> KNOCKBACK_BOOST = MOB_EFFECTS.register("slamming",()->
            new BattleMobEffect(MobEffectCategory.BENEFICIAL, 0x8a539d)
                    .addAttributeModifier(Attributes.ATTACK_KNOCKBACK,
                            ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "effect.knockback_boost"),
                            1.0, AttributeModifier.Operation.ADD_VALUE)
    );

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
