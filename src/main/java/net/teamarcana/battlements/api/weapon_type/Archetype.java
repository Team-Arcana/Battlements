package net.teamarcana.battlements.api.weapon_type;

import com.google.common.collect.ImmutableList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ToolAction;
import net.teamarcana.battlements.api.trait.Trait;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Archetype {
    protected final String name;
    protected final float baseAttackDamage;
    protected final float attackDamageMultiplier;
    protected final float attackSpeed;
    protected Set<ToolAction> toolActions = Set.of();
    protected List<Trait> traits;
    protected boolean isSharp = false;
    protected Optional<Trait> actionTrait = Optional.empty();

    /**
     * Constructor for Weapon Archetypes
     * @param name the name of the archetype
     * @param baseAttackDamage the base attack damage to the archetype
     * @param attackDamageMultiplier the attack damage multiplier for the archetype
     * @param attackSpeed the attack speed of the archetype
     * @param toolActions the tool actions that the archetype can do
     * @param traits the traits
     */
    public Archetype(String name, float baseAttackDamage, float attackDamageMultiplier, float attackSpeed, boolean isSharp, Set<ToolAction> toolActions, List<Trait> traits){
        this.name = name;
        this.baseAttackDamage = baseAttackDamage;
        this.attackDamageMultiplier = attackDamageMultiplier;
        this.attackSpeed = attackSpeed;
        this.isSharp = isSharp;
        this.toolActions = toolActions;

        // adding the traits to the list
        // only one action trait can be in an archetype at a time,
        // so to prevent errors, it only puts in the first action trait in the inputted list
        traits.forEach(trait -> {
            if(trait.isAction() && actionTrait.isEmpty()){ actionTrait = Optional.of(trait); this.traits.add(trait); }
            if(!trait.isAction()){ this.traits.add(trait); }
        });
    }
    public Archetype(String name, float baseAttackDamage, float attackDamageMultiplier, float attackSpeed, boolean isSharp, Set<ToolAction> toolActions, Trait... traits){
        this(name, baseAttackDamage, attackDamageMultiplier, attackSpeed, isSharp, toolActions, ImmutableList.copyOf(traits));
    }

    public Archetype setSharp(boolean sharp) { this.isSharp = sharp; return this; }
    public boolean isSharp(){ return isSharp; }

    public String getName() { return name; }
    public float getBaseAttackDamage() { return baseAttackDamage; }
    public float getAttackDamageMultiplier() { return attackDamageMultiplier; }
    public float getAttackSpeed() { return attackSpeed; }

    public List<Trait> getTraits() { return traits; }

    public Set<ToolAction> getToolActions() { return toolActions; }
    public boolean canPerformToolAction(ToolAction action){ return toolActions.contains(action); }

    public Optional<Trait> getActionTrait(){ return actionTrait; }

    public void addTraitsToTooltip(ItemStack item, List<Component> tooltip, boolean isShiftPressed){
        if(traits != null){
            traits.forEach(trait -> trait.addTooltip(item, tooltip, isShiftPressed));
        }
    }
}
