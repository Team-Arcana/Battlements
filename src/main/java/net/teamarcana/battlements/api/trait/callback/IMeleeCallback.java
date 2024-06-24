package net.teamarcana.battlements.api.trait.callback;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

/**
 * Callback thingy for melee traits
 * implement this when making a trait to add some custom behaviors
 */
public interface IMeleeCallback {
    public static float modifyDealtDamage(Tier tier, float baseDMG, DamageSource source, LivingEntity attacker, LivingEntity target){ return baseDMG; }
    public static float modifyTakenDamage(Tier tier, float baseDMG, DamageSource source, LivingEntity attacker, LivingEntity target){ return baseDMG; }

    // default stuff that we'll get into later
    public default void onInventoryTick(Tier tier, ItemStack item, Level level, LivingEntity entity, int itemSlot, boolean isSelected){}
    public default void postHurtEnemy(Tier tier, ItemStack item, LivingEntity target, LivingEntity attacker, Entity projectile){}
    public default void hurtEnemy(Tier tier, ItemStack item, LivingEntity target, LivingEntity attacker, Entity projectile){}
    public default void onModifyAttributes(ItemAttributeModifiers.Builder attributes){}
    public default void onCraftedBy(Tier tier, ItemStack item, Level level, Player player){}
}
