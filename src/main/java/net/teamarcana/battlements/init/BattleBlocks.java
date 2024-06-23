package net.teamarcana.battlements.init;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;

public class BattleBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Battlements.MOD_ID);



    public static void register(IEventBus eventBus){ BLOCKS.register(eventBus); }
}
