package net.teamarcana.battlements.init;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.teamarcana.battlements.item.ParryingWeaponItem;
import net.teamarcana.battlements.item.ThrowingWeaponItem;

public class BattleItemProperties {
    public static void addCustomItemProperties() {
        registerMeleeWeaponModelProperties(BattleItems.GOLDEN_KATANA.get());
        registerMeleeWeaponModelProperties(BattleItems.IRON_KATANA.get());
        registerMeleeWeaponModelProperties(BattleItems.STEEL_KATANA.get());
        registerMeleeWeaponModelProperties(BattleItems.DIAMOND_KATANA.get());
        registerMeleeWeaponModelProperties(BattleItems.NETHERITE_KATANA.get());

        registerMeleeWeaponModelProperties(BattleItems.WOODEN_BOOMERANG.get());
        registerMeleeWeaponModelProperties(BattleItems.GOLDEN_BOOMERANG.get());
        registerMeleeWeaponModelProperties(BattleItems.IRON_BOOMERANG.get());
        registerMeleeWeaponModelProperties(BattleItems.STEEL_BOOMERANG.get());
        registerMeleeWeaponModelProperties(BattleItems.DIAMOND_BOOMERANG.get());
        registerMeleeWeaponModelProperties(BattleItems.NETHERITE_BOOMERANG.get());

        registerMeleeWeaponModelProperties(BattleItems.WOODEN_QUARTERSTAFF.get());
        registerMeleeWeaponModelProperties(BattleItems.GOLDEN_QUARTERSTAFF.get());
        registerMeleeWeaponModelProperties(BattleItems.IRON_QUARTERSTAFF.get());
        registerMeleeWeaponModelProperties(BattleItems.STEEL_QUARTERSTAFF.get());
        registerMeleeWeaponModelProperties(BattleItems.DIAMOND_QUARTERSTAFF.get());
        registerMeleeWeaponModelProperties(BattleItems.NETHERITE_QUARTERSTAFF.get());

        registerMeleeWeaponModelProperties(BattleItems.FLINT_JAVELIN.get());
        registerMeleeWeaponModelProperties(BattleItems.GOLDEN_JAVELIN.get());
        registerMeleeWeaponModelProperties(BattleItems.IRON_JAVELIN.get());
        registerMeleeWeaponModelProperties(BattleItems.STEEL_JAVELIN.get());
        registerMeleeWeaponModelProperties(BattleItems.DIAMOND_JAVELIN.get());
        registerMeleeWeaponModelProperties(BattleItems.NETHERITE_JAVELIN.get());

    }

    public static void registerMeleeWeaponModelProperties (Item item){
        ItemProperties.register(item, BattleModelOverrides.PARRYING, (itemStack, level, entity, i) -> itemStack.getItem() instanceof ParryingWeaponItem &&  entity != null && entity.isUsingItem() && entity.getUseItem() == itemStack ? 1.0f : 0.0f);
        ItemProperties.register(item, BattleModelOverrides.THROWING, (itemStack, level, entity, i) -> itemStack.getItem() instanceof ThrowingWeaponItem && entity != null && entity.isUsingItem() && entity.getUseItem() == itemStack ? 1.0f : 0.0f);
    }
}
