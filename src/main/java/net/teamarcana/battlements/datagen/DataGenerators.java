package net.teamarcana.battlements.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.teamarcana.battlements.Battlements;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Battlements.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new BattleRecipeProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), BattleLootTableProvider.create(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(), new BattleBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BattleItemModelProvider(packOutput, existingFileHelper));

        //generator.addProvider(event.includeServer(), new BattleWorldGenProvider(packOutput, lookupProvider));

        BattleBlockTagProvider blockTagGenerator = generator.addProvider(event.includeServer(),
                new BattleBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new BattleItemTagProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new BattleEnchantmentTagProvider(packOutput, lookupProvider));
    }
}