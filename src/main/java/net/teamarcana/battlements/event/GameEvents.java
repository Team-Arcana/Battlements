package net.teamarcana.battlements.event;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.teamarcana.battlements.api.IReloadable;
import net.teamarcana.battlements.api.ReloadHandler;
import net.teamarcana.battlements.init.BattlePotions;
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
}
