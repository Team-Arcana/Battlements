package net.teamarcana.battlements.api.trait;

import net.minecraft.world.item.Item;

import java.util.Collection;
import java.util.List;

/**
 * Interface for items that have traits
 */
public interface TraitContainer<T extends Item> {
    public T getAsItem();
    public boolean hasTrait(Trait trait);
    public boolean hasTraitWithType(String type);
    public Trait getFirstTraitWithType(String type);
    public List<Trait> getAllTraitsWithType(String type);
    public Collection<Trait> getAllTraits();
}
