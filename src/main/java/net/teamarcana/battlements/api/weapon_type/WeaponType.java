package net.teamarcana.battlements.api.weapon_type;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ToolAction;
import net.teamarcana.battlements.api.IReloadable;
import net.teamarcana.battlements.api.ReloadHandler;
import net.teamarcana.battlements.api.weapon_trait.Trait;
import net.teamarcana.battlements.init.BattleTraits;

import javax.imageio.spi.IIORegistry;
import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/**
 * The Base Weapon Type Class
 * extend this to make your own
 */
public class WeaponType implements IReloadable {
    public static final Predicate<Trait> MELEE = Trait::isMelee;
    public static final Predicate<Trait> THROWING = Trait::isThrowing;

    protected final String name;
    protected final TagKey<Trait> traitTag;
    protected List<Trait> traits;
    protected Optional<Trait> actionTrait = Optional.empty();
    protected final Predicate<Trait> filter;
    protected final boolean isSharp;
    protected final Set<ToolAction> toolActions;
    protected final float baseAttackDamage;
    protected final float attackDamageMultiplier;
    protected final float attackSpeed;

    // constructor
    public WeaponType(String name, float baseAttackDamage, float attackDamageMultiplier, float attackSpeed, Boolean isSharp, TagKey<Trait> traitTag, Predicate<Trait> filter, Set<ToolAction> toolActions){
        this.name = name;
        this.baseAttackDamage = baseAttackDamage; this.attackDamageMultiplier = attackDamageMultiplier; this.attackSpeed = attackSpeed;
        this.isSharp = isSharp;
        this.traitTag = traitTag;
        this.filter = filter;
        this.toolActions = toolActions;

        ReloadHandler.addToReloadables(this);
    }
    public WeaponType(String name, float baseAttackDamage, float attackDamageMultiplier, float baseAttackSpeed, Boolean isSharp, TagKey<Trait> traitTag, Predicate<Trait> filter, ToolAction... toolActions){
        this(name, baseAttackDamage, attackDamageMultiplier, baseAttackSpeed, isSharp, traitTag, filter, ImmutableSet.copyOf(toolActions));
    }

    @Override
    public void reload() {
        Registry<Trait> registry = BattleTraits.TRAIT_REGISTRY;
        Optional<HolderSet.Named<Trait>> tag = registry.getTag(traitTag);
        tag.ifPresent(t -> {
            t.forEach(traitHolder -> {
                Trait trait = traitHolder.value();
                if(trait.isAction() && !actionTrait.isPresent() ){ actionTrait = Optional.of(trait); }
                if(!trait.isAction()){ traits.add(trait); }
            });
        });
    }

    public boolean isSharp(){ return isSharp; }
    public boolean canPerformToolAction(ToolAction action){ return toolActions.contains(action); }
    public List<Trait> getTraits(){ return traits; }
    public Optional<Trait> getActionTrait(){ return actionTrait; }
    public String getName(){ return name; }
    public float getBaseAttackDamage() { return baseAttackDamage; }
    public float getAttackDamageMultiplier() { return attackDamageMultiplier; }
    public float getAttackSpeed() { return attackSpeed; }

    public void addTraitsToTooltip(ItemStack item, List<Component> tooltip, boolean isShiftPressed){
        traits.forEach(trait -> addTraitsToTooltip(item, tooltip, isShiftPressed));
    }
}
