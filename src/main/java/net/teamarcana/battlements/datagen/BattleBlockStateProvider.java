package net.teamarcana.battlements.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.init.BattleBlocks;

public class BattleBlockStateProvider extends BlockStateProvider {
    public BattleBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Battlements.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BattleBlocks.ENDERIUM_BLOCK.get());
        blockWithItem(BattleBlocks.STEEL_BLOCK.get());
        blockWithItem(BattleBlocks.ENDER_CRYSTAL_BLOCk.get());
    }

    private void blockWithItem(Block block){
        simpleBlockWithItem(block, cubeAll(block));
    }
}
