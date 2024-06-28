package net.teamarcana.battlements.event;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.teamarcana.battlements.api.IReloadable;
import net.teamarcana.battlements.api.ReloadHandler;
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
        Log.info(String.format("Finished initialising Weapon Traits & Attributes! Took %s ms", milliseconds));
    }
}
