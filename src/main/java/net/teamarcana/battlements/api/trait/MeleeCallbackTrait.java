package net.teamarcana.battlements.api.trait;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.teamarcana.battlements.api.trait.callback.IMeleeCallback;

import java.util.Optional;

public class MeleeCallbackTrait extends Trait implements IMeleeCallback {
    /**
     * The constructor for the Trait
     *
     * @param name    the name of the trait
     * @param modId   the mod ID that the trait is registered from
     * @param quality the trait's quality. Can be "positive", "neutral", or "negative"
     */
    public MeleeCallbackTrait(String name, String modId, String quality) {
        super(name, modId, quality);
    }

    @Override
    public Optional<IMeleeCallback> getMeleeCallback() {
        return Optional.of(this);
    }

    @Override
    public void onInventoryTick(Tier tier, ItemStack item, Level level, LivingEntity entity, int itemSlot, boolean isSelected) {}
    @Override
    public void hurtEnemy(Tier tier, ItemStack item, LivingEntity target, LivingEntity attacker, Entity projectile) {}
    @Override
    public void postHurtEnemy(Tier tier, ItemStack item, LivingEntity target, LivingEntity attacker, Entity projectile) {}
    @Override
    public void onModifyAttributes(ItemAttributeModifiers.Builder attributes) {}
    @Override
    public void onCraftedBy(Tier tier, ItemStack item, Level level, Player player) {}
}
