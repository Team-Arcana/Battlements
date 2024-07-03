package net.teamarcana.battlements.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.util.TooltipUtil;

import java.util.List;

@EventBusSubscriber(modid = Battlements.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClientEvents {
    // tooltip modification
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack item = event.getItemStack();
        Item.TooltipContext context = event.getContext();
        TooltipFlag flag = event.getFlags();

        Player player = Minecraft.getInstance().player;
        if(player == null){ return; }
        TooltipUtil.itemAttributeTooltip(item, player, event.getToolTip(), Screen.hasShiftDown());
    }
}
