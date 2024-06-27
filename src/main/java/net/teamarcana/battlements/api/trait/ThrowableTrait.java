package net.teamarcana.battlements.api.trait;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.teamarcana.battlements.api.trait.callback.IActionCallback;

public class ThrowableTrait extends Trait implements IActionCallback {
    /**
     * The constructor for the Trait
     *
     * @param type    the name of the trait
     * @param modId   the mod ID that the trait is registered from
     * @param quality the trait's quality. Can be "positive", "neutral", or "negative"
     */
    public ThrowableTrait(String type, String modId, String quality) {
        super(type, modId, quality);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return IActionCallback.super.useOn(context);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(ItemStack item, Player player, Level level, InteractionHand hand) {
        return null;
    }

    @Override
    public void releaseUsing(ItemStack item, Level level, LivingEntity entity, int timeLeft, float damage) {
        IActionCallback.super.releaseUsing(item, level, entity, timeLeft, damage);
    }

    @Override
    public void onUseTick(ItemStack item, LivingEntity user, int count, float damage) {
        IActionCallback.super.onUseTick(item, user, count, damage);
    }

    @Override
    public int getUseDuration(ItemStack item, Entity entity) {
        return IActionCallback.super.getUseDuration(item, entity);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack item) {
        return IActionCallback.super.getUseAnimation(item);
    }
}
