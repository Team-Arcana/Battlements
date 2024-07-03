package net.teamarcana.battlements.api.archetype;

import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;

import java.util.List;
import java.util.Set;

public class Archetype{
    protected final String name;
    protected final String modId;
    protected final float baseAttackDamage;
    protected final float attackDamageMultiplier;
    protected final float attackSpeed;
    protected final float size;

    protected int twoHanded = 0;
    protected boolean hasExtendedReach = false;

    protected float knockbackMod = 0;

    protected Set<ToolAction> toolActions = Set.of();
    protected final TagKey<Block> effectiveBlocks;
    protected boolean isSharp = false;

    /**
     * Constructor for Weapon Archetypes
     * @param name the name of the archetype
     * @param baseAttackDamage the base attack damage to the archetype
     * @param attackDamageMultiplier the attack damage multiplier for the archetype
     * @param attackSpeed the attack speed of the archetype
     * @param size the size of the archetype
     * @param toolActions the tool actions that the archetype can do
     * @param effectiveBlocks the blocks that the archetype can effectively dig through
     */
    public Archetype(String name, String modId, float baseAttackDamage, float attackDamageMultiplier, float attackSpeed, float size, boolean isSharp, Set<ToolAction> toolActions, TagKey<Block> effectiveBlocks){
        this.name = name;
        this.modId = modId;
        this.baseAttackDamage = baseAttackDamage;
        this.attackDamageMultiplier = attackDamageMultiplier;
        this.attackSpeed = attackSpeed;
        this.size = size;

        this.isSharp = isSharp;
        this.toolActions = toolActions;
        this.effectiveBlocks = effectiveBlocks;
    }
    public Archetype(String name, String modId, float baseAttackDamage, float attackDamageMultiplier, float attackSpeed, float size, boolean isSharp, Set<ToolAction> toolActions){
        this(name, modId, baseAttackDamage, attackDamageMultiplier, attackSpeed, size, isSharp, toolActions, null);
    }

    public Archetype setSharp(boolean sharp) { this.isSharp = sharp; return this; }
    public boolean isSharp(){ return isSharp; }

    public String getName() { return name; }
    public String getModId() { return modId; }
    public float getBaseAttackDamage() { return baseAttackDamage; }
    public float getAttackDamageMultiplier() { return attackDamageMultiplier; }
    public float getAttackSpeed() { return attackSpeed; }
    public float getSize(){ return size; }

    public Set<ToolAction> getToolActions() { return toolActions; }
    public boolean canPerformToolAction(ToolAction action){ return toolActions.contains(action); }
    public TagKey<Block> getEffectiveBlocks(){ return effectiveBlocks; }
    public boolean isEffective(BlockState state){ return state.is(effectiveBlocks); }

    public Archetype setKnockbackModifier(float modifier){ this.knockbackMod = modifier; return this; }
    public float getKnockbackMod(){ return knockbackMod; }

    public Archetype setTwoHanded(int twoHanded){ this.twoHanded = twoHanded; return this; }
    public int getTwoHanded(){ return twoHanded; }
    public Archetype setExtendedReach(){ this.hasExtendedReach = true; return this; }
    public boolean hasExtendedReach(){ return hasExtendedReach; }

    public void addArchetypeDescription(ItemStack item, List<Component> tooltip, boolean isShiftPressed){
        if(isShiftPressed && I18n.exists(String.format("tooltip.%s." + name + "_description", modId))){
            tooltip.add(Component.translatable(String.format("tooltip.%s." + name + "_description", modId))
                    .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        }
    }
}
