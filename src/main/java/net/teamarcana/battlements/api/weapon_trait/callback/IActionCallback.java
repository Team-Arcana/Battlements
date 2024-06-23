package net.teamarcana.battlements.api.weapon_trait.callback;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelReader;

import java.util.logging.Level;

/**
 * Callback thingy for action traits
 * implement this when making a trait to add some custom behaviors
 */
public interface IActionCallback {
    public default InteractionResult useOn(UseOnContext context){ return InteractionResult.PASS; }
    public InteractionResultHolder<ItemStack> use(ItemStack item, Player player, Level level, InteractionHand hand);
    public default void releaseUsing(ItemStack item, Level level, LivingEntity entity, int timeLeft, float damage){}
    public default void onUseTick(ItemStack item, LivingEntity user, int count, float damage){}
    public default int getUseDuration(ItemStack item){ return 72000; }
    public default UseAnim getUseAnimation(ItemStack item){ return UseAnim.NONE; }
    public default boolean doesSneakBypassUse(ItemStack item, LevelReader level, BlockPos pos, Player player){ return false; }
}
