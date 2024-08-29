package net.teamarcana.battlements.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.teamarcana.battlements.api.archetype.Archetype;
import net.teamarcana.battlements.entity.AbstractThrownWeapon;
import net.teamarcana.battlements.init.BattleEntities;

import java.util.List;

public class ThrowingWeaponItem extends BaseWeaponItem{
    protected float baseVelocity = 2.0f;
    public ThrowingWeaponItem(Tier tier, Archetype archetype, Properties properties) {
        super(tier, archetype, properties);
    }
    public ThrowingWeaponItem(Tier tier, Archetype archetype, Properties properties, String customName) {
        super(tier, archetype, properties, customName);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(item);
    }

    @Override
    public int getUseDuration(ItemStack item, LivingEntity pEntity) { return 72000; }

    @Override
    public UseAnim getUseAnimation(ItemStack item) {
        return UseAnim.SPEAR;
    }

    @Override
    public void releaseUsing(ItemStack item, Level level, LivingEntity entity, int timeCharged) {
        if(entity instanceof Player player){
            int maxCharge = getMaxCharge();
            int charge = Math.min(getUseDuration(item, entity) - timeCharged, maxCharge);
            if(charge > 2){
                if(!level.isClientSide()){
                    EquipmentSlot slot = entity.getUsedItemHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                    item.hurtAndBreak(1, player, slot);

                    AbstractThrownWeapon thrownWeapon = createThrownWeapon(level, player, item, charge);
                    float c = ((float) charge / maxCharge);
                    if(thrownWeapon == null){ return; }
                    //thrownWeapon.setWeapon(item);

                    int bonusVelocity = 0;
                    float damageMultiplier = (Math.abs(this.getArchetype().getAttackDamageMultiplier() - 1.0f)) * c + 1;
                    thrownWeapon.setBaseDamage((getAttackDamage() + 1) * damageMultiplier);

                    thrownWeapon.shootFromRotation(player, player.xRotO, player.yRotO, 0.0f, baseVelocity * ((bonusVelocity*0.2f) + 1) * c, 0.5f);
                    if(player.getAbilities().instabuild){
                        thrownWeapon.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    }

                    if(thrownWeapon.isValid()){
                        level.addFreshEntity(thrownWeapon);
                        level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), getArchetype().getThrowSound(), SoundSource.PLAYERS, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));
                        if(!player.getAbilities().instabuild){
                            player.getInventory().removeItem(item);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }

        super.releaseUsing(item, level, entity, timeCharged);
    }

    public AbstractThrownWeapon createThrownWeapon(Level level, Player player, ItemStack item, int charge){
        return new AbstractThrownWeapon(BattleEntities.THROWN_WEAPON.get(), level, player, item).setWeapon(item).setBaseDamage(getAttackDamage());
    }

    public int getMaxCharge(){
        return (int) this.getArchetype().getChargeTicks();
    }

    @Override
    public void appendHoverText(ItemStack item, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(item, context, tooltip, flag);
        tooltip.addLast(Component.translatable("tooltip.battlements.throw_boost").withStyle(ChatFormatting.BLUE));
    }
}
