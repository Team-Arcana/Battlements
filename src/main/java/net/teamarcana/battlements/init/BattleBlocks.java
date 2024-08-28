package net.teamarcana.battlements.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamarcana.battlements.Battlements;

public class BattleBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Battlements.MOD_ID);

    public static final DeferredBlock<Block> STEEL_BLOCK = BLOCKS.registerSimpleBlock("steel_block",
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.NETHERITE_BLOCK));

    public static void register(IEventBus eventBus){ BLOCKS.register(eventBus); }
}
