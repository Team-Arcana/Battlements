package net.teamarcana.battlements.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.init.BattleBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BattleBlockTagProvider extends BlockTagsProvider {
    public BattleBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Battlements.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.BEACON_BASE_BLOCKS).add(BattleBlocks.ENDERIUM_BLOCK.get(), BattleBlocks.STEEL_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BattleBlocks.ENDERIUM_BLOCK.get(), BattleBlocks.STEEL_BLOCK.get(), BattleBlocks.ENDER_CRYSTAL_BLOCk.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(BattleBlocks.STEEL_BLOCK.get(), BattleBlocks.ENDER_CRYSTAL_BLOCk.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(BattleBlocks.ENDERIUM_BLOCK.get());
    }
}
