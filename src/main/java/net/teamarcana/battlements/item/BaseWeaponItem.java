package net.teamarcana.battlements.item;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import net.teamarcana.battlements.api.IReloadable;
import net.teamarcana.battlements.api.ReloadHandler;
import net.teamarcana.battlements.api.trait.TraitContainer;
import net.teamarcana.battlements.api.trait.Trait;
import net.teamarcana.battlements.api.trait.VersatileTrait;
import net.teamarcana.battlements.api.archetype.Archetype;
import net.teamarcana.battlements.init.BattleTraitTypes;
import net.teamarcana.battlements.init.BattleTraits;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BaseWeaponItem extends TieredItem implements TraitContainer<BaseWeaponItem>, IReloadable {
    protected String customName = null;
    protected static ItemAttributeModifiers modifiers;
    protected Archetype archetype;
    protected static List<Trait> traits = List.of();
    protected static Tier tier;
    protected static float attackDamage;
    protected static float attackSpeed;


    public BaseWeaponItem(Tier tier, Archetype archetype, Properties properties) {
        super(tier, properties.durability(tier.getUses()).attributes(BaseWeaponItem.createBaseModifiers(tier, archetype)));
        this.tier = tier;
        this.archetype = archetype;
        ReloadHandler.addToReloadables(this);
    }
    public BaseWeaponItem(Tier tier, Archetype archetype, Properties properties, String customName) {
        this(tier, archetype, properties);
        this.customName = customName;
    }

    @Override
    public void reload(RegistryAccess registryAccess) {
        ImmutableList.Builder<Trait> traitBuilder = new ImmutableList.Builder<>();
        traitBuilder.addAll(archetype.getTraits());
        traits = traitBuilder.build();

        attackDamage = (tier.getAttackDamageBonus() * archetype.getAttackDamageMultiplier()) + archetype.getBaseAttackDamage() - 1.0f;
        attackSpeed = archetype.getAttackSpeed();

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
        traits.forEach(trait -> {
            trait.getMeleeCallback().ifPresent(callback -> callback.onModifyAttributes(attributeModifiers));
        });
        modifiers = attributeModifiers.build();
    }

    public static ItemAttributeModifiers createBaseModifiers(Tier tier, Archetype archetype){
        attackDamage = (tier.getAttackDamageBonus() * archetype.getAttackDamageMultiplier()) + archetype.getBaseAttackDamage() - 1.0f;
        attackSpeed = archetype.getAttackSpeed();

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
        return attributeModifiers.build();
    }

    public boolean isVersatile(){ return hasTraitWithType(BattleTraitTypes.VERSATILE); }
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
        archetype.addTraitsToTooltip(item, tooltip, isShiftPressed);
        super.appendHoverText(item, context, tooltip, flag);
    }

    @Override
    public float getDestroySpeed(ItemStack item, BlockState state) {
        for(Trait trait : getAllTraitsWithType(BattleTraitTypes.VERSATILE)){
            VersatileTrait versatileTrait = ((VersatileTrait) trait);
            if(state.is(versatileTrait.getEffectiveBlocks())){
                return tier.getSpeed();
            }
        }
        if(archetype.isSharp()){ return state.is(Blocks.COBWEB) ? 15.0f : (state.is(BlockTags.SWORD_EFFICIENT) ? 1.5f : 1.0f); }
        return super.getDestroySpeed(item, state);
    }

    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int slot, boolean isSelected) {
        if(entity instanceof LivingEntity living){
            traits.forEach(trait -> trait.getMeleeCallback().ifPresent(callback -> inventoryTick(item, level, living, slot, isSelected)));
        }
        super.inventoryTick(item, level, entity, slot, isSelected);
    }

    @Override
    public boolean mineBlock(ItemStack item, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (state.getDestroySpeed(level, pos) != 0.0F){
            for (Trait trait : getAllTraitsWithType(BattleTraitTypes.VERSATILE)) {
                VersatileTrait versatileTrait = (VersatileTrait) trait;
                if (state.is(versatileTrait.getEffectiveBlocks())) {
                    item.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                } else {
                    item.hurtAndBreak(2, entity, EquipmentSlot.MAINHAND);
                }
            }
            if(!hasTraitWithType(BattleTraitTypes.VERSATILE)){
                item.hurtAndBreak(2, entity, EquipmentSlot.MAINHAND);
            }
        }
        return true;
    }

    @Override
    public boolean canDisableShield(ItemStack item, ItemStack shield, LivingEntity target, LivingEntity attacker) {
        return hasTrait(BattleTraits.SHIELD_BREACH.get()) || super.canDisableShield(item, shield, target, attacker);
    }

    @Override
    public boolean hurtEnemy(ItemStack item, LivingEntity target, LivingEntity attacker) {
        traits.forEach(trait -> trait.getMeleeCallback().ifPresent(callback -> callback.hurtEnemy(tier, item, target, attacker, null)));
        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack item, LivingEntity target, LivingEntity attacker) {
        traits.forEach(trait -> trait.getMeleeCallback().ifPresent(callback -> callback.postHurtEnemy(tier, item, target, attacker, null)));
        item.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Optional<Trait> actionTrait = archetype.getActionTrait();
        if(actionTrait.isPresent()){
            actionTrait.get().getActionCallback().ifPresent(actionCallback -> actionCallback.useOn(context));
        }
        return super.useOn(context);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        Optional<Trait> actionTrait = archetype.getActionTrait();
        if(actionTrait.isPresent()){
            actionTrait.get().getActionCallback().ifPresent(actionCallback -> actionCallback.use(item, player, level, hand));
        }
        return super.use(level, player, hand);
    }

    @Override
    public void releaseUsing(ItemStack item, Level level, LivingEntity entity, int timeCharged) {
        Optional<Trait> actionTrait = archetype.getActionTrait();
        if(actionTrait.isPresent()){
            actionTrait.get().getActionCallback().ifPresent(actionCallback -> actionCallback.releaseUsing(item, level, entity, timeCharged, attackDamage));
        }
        super.releaseUsing(item, level, entity, timeCharged);
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack item, int remainingDuration) {
        Optional<Trait> actionTrait = archetype.getActionTrait();
        if(actionTrait.isPresent()){
            actionTrait.get().getActionCallback().ifPresent(callback -> callback.onUseTick(item, entity, remainingDuration, attackDamage));
        }
        super.onUseTick(level, entity, item, remainingDuration);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack item) {
        Optional<Trait> actionTrait = archetype.getActionTrait();
        if(actionTrait.isPresent()){
            Trait trait = actionTrait.get();
            if(trait.getActionCallback().isPresent()){
                return trait.getActionCallback().get().getUseAnimation(item);
            }
        }
        return super.getUseAnimation(item);
    }

    @Override
    public int getUseDuration(ItemStack item, LivingEntity entity) {
        Optional<Trait> actionTrait = archetype.getActionTrait();
        if(actionTrait.isPresent()){
            Trait trait = actionTrait.get();
            if(trait.getActionCallback().isPresent()){
                return trait.getActionCallback().get().getUseDuration(item, entity);
            }
        }
        return super.getUseDuration(item, entity);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack item, LevelReader level, BlockPos pos, Player player) {
        Optional<Trait> actionTrait = archetype.getActionTrait();
        if(actionTrait.isPresent()){
            Trait trait = actionTrait.get();
            if(trait.getActionCallback().isPresent()){
                return trait.getActionCallback().get().doesSneakBypassUse(item, level, pos, player);
            }
        }
        return super.doesSneakBypassUse(item, level, pos, player);
    }

    @Override
    public void onCraftedBy(ItemStack item, Level level, Player player) {
        traits.forEach(trait -> trait.getMeleeCallback().ifPresent(callback -> callback.onCraftedBy(tier, item, level, player)));
        super.onCraftedBy(item, level, player);
    }

    @Override
    public boolean canPerformAction(ItemStack item, ToolAction action) {
        return archetype.canPerformToolAction(action);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        for(Trait trait : getAllTraitsWithType(BattleTraitTypes.VERSATILE)){
            VersatileTrait versatileTrait = ((VersatileTrait) trait);
            if(state.is(versatileTrait.getEffectiveBlocks())){ return true; }
        }
        return !player.isCreative() && super.canAttackBlock(state, level, pos, player);
    }

    // stuff for traitcontainer
    @Override
    public BaseWeaponItem getAsItem() {
        return this;
    }

    @Override
    public boolean hasTrait(Trait trait) {
        return traits.contains(trait);
    }

    @Override
    public boolean hasTraitWithType(String type) {
        return traits.stream().anyMatch(trait -> trait.getType().equals(type));
    }

    @Override
    public Trait getFirstTraitWithType(String type) {
        for(Trait trait : traits){
            if(trait.getType().equals(type)){ return trait; }
        }
        return null;
    }

    @Override
    public List<Trait> getAllTraitsWithType(String type) {
        return traits.stream().filter(trait -> trait.getType().equals(type)).toList();
    }

    @Override
    public Collection<Trait> getAllTraits() {
        return traits;
    }

    public static boolean hasTraits(){ return !traits.isEmpty(); }
}
