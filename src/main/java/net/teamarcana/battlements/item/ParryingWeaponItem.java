package net.teamarcana.battlements.item;

import net.minecraft.world.item.Tier;
import net.teamarcana.battlements.api.archetype.Archetype;

public class ParryingWeaponItem extends BaseWeaponItem{
    public ParryingWeaponItem(Tier tier, Archetype archetype, Properties properties) {
        super(tier, archetype, properties);
    }

    public ParryingWeaponItem(Tier tier, Archetype archetype, Properties properties, String customName) {
        super(tier, archetype, properties, customName);
    }
}
