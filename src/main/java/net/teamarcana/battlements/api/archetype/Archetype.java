package net.teamarcana.battlements.api.archetype;

import net.minecraft.core.*;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ToolAction;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.IReloadable;
import net.teamarcana.battlements.api.ReloadHandler;
import net.teamarcana.battlements.api.trait.Trait;
import org.jline.utils.Log;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Archetype implements IReloadable {
    protected final String name;
    protected final float baseAttackDamage;
    protected final float attackDamageMultiplier;
    protected final float attackSpeed;
    protected Set<ToolAction> toolActions = Set.of();
    protected TagKey<Trait> traitTag;
    protected boolean validTag = true;
    protected List<Trait> traits = List.of();
    protected boolean isSharp = false;
    protected Optional<Trait> actionTrait = Optional.empty();

    /**
     * Constructor for Weapon Archetypes
     * @param name the name of the archetype
     * @param baseAttackDamage the base attack damage to the archetype
     * @param attackDamageMultiplier the attack damage multiplier for the archetype
     * @param attackSpeed the attack speed of the archetype
     * @param toolActions the tool actions that the archetype can do
     * @param traitTag the tag for the traits to be applied to
     */
    public Archetype(String name, float baseAttackDamage, float attackDamageMultiplier, float attackSpeed, boolean isSharp, Set<ToolAction> toolActions, TagKey<Trait> traitTag){
        this.name = name;
        this.baseAttackDamage = baseAttackDamage;
        this.attackDamageMultiplier = attackDamageMultiplier;
        this.attackSpeed = attackSpeed;
        this.isSharp = isSharp;
        this.toolActions = toolActions;
        this.traitTag = traitTag;

        ReloadHandler.addToReloadables(this);
    }

    @Override
    public void reload(RegistryAccess registryAccess) {
        // getting the tag
        Registry<Trait> traitRegistry = registryAccess.registryOrThrow(Battlements.TRAIT_REGISTRY_KEY);
        HolderLookup.RegistryLookup<Trait> traitLookup = traitRegistry.asTagAddingLookup();
        if(validTag != traitLookup.listTagIds().anyMatch(tag -> tag == traitTag)){
            Log.debug(String.format("[ERROR]: trait tag [" + traitTag.location() + "] is not found for the %s archetype", name)); }

        Optional<HolderSet.Named<Trait>> tag = traitLookup.get(traitTag);
        // adding the traits to the list
        // only one action trait can be in an archetype at a time,
        // so to prevent errors, it only puts in the first action trait in the inputted list
        tag.ifPresent(holders -> traits = holders.stream().filter(namedTrait -> {
            Trait trait = namedTrait.value();
            if (trait.isAction()) {
                if (actionTrait.isPresent()) {
                    actionTrait = Optional.of(trait);
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }).map(Holder::value).toList());
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
    public boolean hasTraits(){ return traits != null && !traits.isEmpty(); }
}
