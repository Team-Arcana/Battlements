package net.teamarcana.battlements.item;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.archetype.Archetype;
import net.teamarcana.battlements.init.BattleMobEffects;

import java.util.List;

public class BaseWeaponItem extends TieredItem{
    protected String customName = null;
    protected static ItemAttributeModifiers modifiers;
    protected Archetype archetype;
    protected static Tier tier;
    protected static float attackDamage;
    protected static float attackSpeed;
    protected static float knockbackMod;
    private boolean applyPenalty = false;
    public void setTwoHandedPenalty(boolean b){ applyPenalty = b; }

    public static final ResourceLocation BASE_ENTITY_REACH_ID = ResourceLocation.withDefaultNamespace("base_entity_reach");
    public static final ResourceLocation BASE_ATTACK_KNOCKBACK_ID = ResourceLocation.withDefaultNamespace("base_attack_knockback");

    public BaseWeaponItem(Tier tier, Archetype archetype, Properties properties) {
        super(tier, properties.durability(tier.getUses()).attributes(BaseWeaponItem.createAttributeModifiers(tier, archetype)));
        this.tier = tier;
        this.archetype = archetype;
    }
    public BaseWeaponItem(Tier tier, Archetype archetype, Properties properties, String customName) {
        this(tier, archetype, properties);
        this.customName = customName;
    }

    public static ItemAttributeModifiers createAttributeModifiers(Tier tier, Archetype archetype){
        attackDamage = (tier.getAttackDamageBonus() * archetype.getAttackDamageMultiplier()) + archetype.getBaseAttackDamage() - 1.0f;
        attackSpeed = archetype.getAttackSpeed();
        knockbackMod = archetype.getKnockbackMod();

        // initialize the item modifiers
        ItemAttributeModifiers.Builder attributeModifiers = ItemAttributeModifiers.builder();
        attributeModifiers.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(
                        BASE_ATTACK_DAMAGE_ID,
                        attackDamage,
                        AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.MAINHAND
        ).add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed - 4.0d, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        if(archetype.getSize() > 0 && !Battlements.isBetterCombatHere()){
            attributeModifiers.add(
                    Attributes.ENTITY_INTERACTION_RANGE,
                    new AttributeModifier(
                            BASE_ENTITY_REACH_ID,
                            (5 + archetype.getSize()) - 5.0f,
                            AttributeModifier.Operation.ADD_VALUE
                    ),
                    EquipmentSlotGroup.MAINHAND
            );
        }
        if(archetype.getKnockbackMod() > 0){
            attributeModifiers.add(
                    Attributes.ATTACK_KNOCKBACK,
                    new AttributeModifier(
                            BASE_ATTACK_KNOCKBACK_ID,
                            knockbackMod,
                            AttributeModifier.Operation.ADD_VALUE
                    ),
                    EquipmentSlotGroup.MAINHAND
            );
        }
        modifiers = attributeModifiers.build();
        return modifiers;
    }

    public Archetype getArchetype() { return archetype; }

    @Override
    public ItemAttributeModifiers getAttributeModifiers(ItemStack item) { return modifiers != null  ? modifiers : super.getAttributeModifiers(item); }

    @Override
    public Component getName(ItemStack item) {
        if(customName == null)
            return super.getName(item);
        return Component.translatable(String.format("customname.battlements.%s", customName));
    }

    @Override
    public void appendHoverText(ItemStack item, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        boolean isShiftPressed = Screen.hasShiftDown();
        archetype.addArchetypeDescription(item, tooltip, isShiftPressed);
        super.appendHoverText(item, context, tooltip, flag);
    }

    @Override
    public float getDestroySpeed(ItemStack item, BlockState state) {
        if(archetype.getEffectiveBlocks() != null && state.is(archetype.getEffectiveBlocks())){
            return tier.getSpeed();
        }
        if(archetype.isSharp()){ return state.is(Blocks.COBWEB) ? 15.0f : (state.is(BlockTags.SWORD_EFFICIENT) ? 1.5f : 1.0f); }
        return 1.0f;
    }
    @Override
    public boolean mineBlock(ItemStack item, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (state.getDestroySpeed(level, pos) != 0.0F){
            if (archetype.getEffectiveBlocks() != null && state.is(archetype.getEffectiveBlocks())) {
                item.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
            } else {
                item.hurtAndBreak(2, entity, EquipmentSlot.MAINHAND);
            }
        }
        return true;
    }

    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int slot, boolean isSelected) {
        if(entity instanceof LivingEntity livingEntity){
            // Offhand Penalty for TwoHanded Items [applies if Better Combat is not installed]
            if(this.getArchetype().getTwoHanded() > 0){
                boolean emptyOffHand = this.getArchetype().getTwoHanded() > 0 && livingEntity.getItemInHand(InteractionHand.OFF_HAND).isEmpty();
                setTwoHandedPenalty(!emptyOffHand && !Battlements.isBetterCombatHere);
                if(applyPenalty && ((LivingEntity) entity).getItemInHand(InteractionHand.MAIN_HAND) == item){
                    livingEntity.addEffect(new MobEffectInstance(BattleMobEffects.ENCUMBERED, 20, Math.max(this.getArchetype().getTwoHanded() - 1, 0), false, false, false));
                }
            }
        }
        super.inventoryTick(item, level, entity, slot, isSelected);
    }

    @Override
    public boolean hurtEnemy(ItemStack item, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack item, LivingEntity target, LivingEntity attacker) {
        item.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public void onCraftedBy(ItemStack item, Level level, Player player) {
        super.onCraftedBy(item, level, player);
    }

    @Override
    public boolean canPerformAction(ItemStack item, ToolAction action) {
        return archetype.canPerformToolAction(action);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        if(archetype.getEffectiveBlocks() != null && state.is(archetype.getEffectiveBlocks())){ return true; }
        return !player.isCreative() && super.canAttackBlock(state, level, pos, player);
    }
}
