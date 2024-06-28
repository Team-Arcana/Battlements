package net.teamarcana.battlements.api;

import net.minecraft.core.RegistryAccess;

/**
 * For reloading stuff
 * you will need to manually add each instance to the reload list
 */
public interface IReloadable {
    public default void reload(RegistryAccess registryAccess){}
}
