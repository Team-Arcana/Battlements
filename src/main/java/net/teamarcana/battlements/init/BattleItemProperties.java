package net.teamarcana.battlements.init;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.teamarcana.battlements.item.ParryingWeaponItem;
import net.teamarcana.battlements.item.ThrowingWeaponItem;

public class BattleItemProperties {
    public static void addCustomItemProperties() {

    }

    public static void registerMeleeWeaponModelProperties (Item item){
        ItemProperties.register(item, BattleModelOverrides.PARRYING, (itemStack, level, entity, i) -> itemStack.getItem() instanceof ParryingWeaponItem weapon &&  entity != null && entity.isUsingItem() && entity.getUseItem() == itemStack ? 1.0f : 0.0f);
        ItemProperties.register(item, BattleModelOverrides.THROWING, (itemStack, level, entity, i) -> itemStack.getItem() instanceof ThrowingWeaponItem weapon  && entity != null && entity.isUsingItem() && entity.getUseItem() == itemStack ? 1.0f : 0.0f);
    }
}
