package net.teamarcana.battlements.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.teamarcana.battlements.datagen.loot.BattleBlockLootTables;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BattleLootTableProvider {
    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider){
        return new LootTableProvider(output, Collections.EMPTY_SET, List.of(
                BattleBlockLootTables.getEntry()
        ), lookupProvider);
    }
}
