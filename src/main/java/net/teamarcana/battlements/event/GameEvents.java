package net.teamarcana.battlements.event;

import net.minecraft.core.RegistryAccess;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.teamarcana.battlements.api.IReloadable;
import net.teamarcana.battlements.api.ReloadHandler;
import net.teamarcana.battlements.init.BattlePotions;
import net.teamarcana.battlements.item.ParryingWeaponItem;
import org.jline.utils.Log;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public class GameEvents {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onUpdateTags(TagsUpdatedEvent event){
        List<IReloadable> reloadList = ReloadHandler.getReloadList();

        Log.debug(String.format("Initializing reloadables for %s values", reloadList.size()));
        long start = System.nanoTime();
        RegistryAccess registryAccess = event.getRegistryAccess();
        reloadList.forEach((item) -> item.reload(registryAccess));
        long end = System.nanoTime();
        double milliseconds = (end-start) / 1000000.0d;
        Log.info(String.format("Finished initialising reloadables. Took %s ms", milliseconds));
    }
    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(
                Potions.AWKWARD,
                Items.TNT,
                BattlePotions.VOLATILE
        );
        builder.addMix(
                Potions.MUNDANE,
                Items.TNT,
                BattlePotions.VOLATILE
        );
        builder.addMix(
                Potions.THICK,
                Items.TNT,
                BattlePotions.VOLATILE
        );

        builder.addMix(
                Potions.AWKWARD,
                Items.CRIMSON_FUNGUS,
                BattlePotions.TINY
        );
        builder.addMix(
                Potions.MUNDANE,
                Items.CRIMSON_FUNGUS,
                BattlePotions.TINY
        );
        builder.addMix(
                Potions.THICK,
                Items.CRIMSON_FUNGUS,
                BattlePotions.TINY
        );

        builder.addMix(
                Potions.AWKWARD,
                Items.WARPED_FUNGUS,
                BattlePotions.TITAN
        );
        builder.addMix(
                Potions.MUNDANE,
                Items.WARPED_FUNGUS,
                BattlePotions.TITAN
        );
        builder.addMix(
                Potions.THICK,
                Items.WARPED_FUNGUS,
                BattlePotions.TITAN
        );

        builder.addMix(
                Potions.AWKWARD,
                Items.BOWL,
                BattlePotions.BROKEN_ARMOR
        );
        builder.addMix(
                Potions.MUNDANE,
                Items.BOWL,
                BattlePotions.BROKEN_ARMOR
        );
        builder.addMix(
                Potions.THICK,
                Items.BOWL,
                BattlePotions.BROKEN_ARMOR
        );

        builder.addMix(
                Potions.AWKWARD,
                Items.GOAT_HORN,
                BattlePotions.KNOCKBACK_BOOST
        );
        builder.addMix(
                Potions.MUNDANE,
                Items.GOAT_HORN,
                BattlePotions.KNOCKBACK_BOOST
        );
        builder.addMix(
                Potions.THICK,
                Items.GOAT_HORN,
                BattlePotions.KNOCKBACK_BOOST
        );
    }

    @SubscribeEvent
    public static void entityAttackEvent(LivingIncomingDamageEvent event){
        if(event.getEntity() != null){
            LivingEntity target = event.getEntity();
            blockCheck(event, target);
        }
    }

    public static void blockCheck(LivingIncomingDamageEvent event, LivingEntity target){
        if(target.isUsingItem() && !target.getUseItem().isEmpty()){
            ItemStack item = target.getUseItem();
            if(item.getItem() instanceof ParryingWeaponItem weapon){
                DamageSource source = event.getSource();
                float damage = event.getAmount();
                boolean damageItem = false;
                boolean canbeBlocked = source != null && !ParryingWeaponItem.cantBeBlocked(source);

                if(canbeBlocked){
                    Entity trueSource = source.getEntity();

                    if(trueSource instanceof LivingEntity attacker){
                        attacker.knockback(0.3f, target.getX() - attacker.getX(), target.getZ() - attacker.getZ());
                    }
                    damageItem = true;
                }
                if(damageItem){
                    int dmg = (int) Math.floor(damage);
                    item.hurtAndBreak(dmg, target, EquipmentSlot.MAINHAND);
                    target.level().playSound(((Player) null), target.getX(), target.getY(), target.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, SoundSource.PLAYERS, 0.8f, 0.8f);
                    event.setCanceled(true);
                }
            }
        }
    }
}
