package net.teamarcana.battlements.init;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;

public class BattleItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Battlements.MOD_ID);

    public static final DeferredItem<Item> CREATIVE_ICON = ITEMS.registerSimpleItem("battlements_combat_icon", new Item.Properties().stacksTo(1));

    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }
}
