package net.teamarcana.battlements;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
import net.teamarcana.battlements.api.trait.Trait;
import net.teamarcana.battlements.init.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Battlements.MOD_ID)
public class Battlements
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "battlements";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static boolean isBetterCombatHere;

    public static final ResourceKey<Registry<Trait>> TRAIT_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Battlements.MOD_ID, "weapon_traits"));
    public static final Registry<Trait> TRAIT_REGISTRY = new RegistryBuilder<Trait>(TRAIT_KEY).create();

    public Battlements(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerRegistries);

        // registering stuff
        //BattleTraits.WEAPON_TRAITS.makeRegistry((key) -> new RegistryBuilder<>(BattleTraits.REGISTRY_KEY));

        BattleTraits.register(modEventBus);

        BattleBlocks.register(modEventBus);
        BattleItems.register(modEventBus);

        BattleCreativeTabs.register(modEventBus);


        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        //modEventBus.addListener(BattleCreativeTabs::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static boolean isBetterCombatHere(){
        return isBetterCombatHere;
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        isBetterCombatHere = ModList.get().isLoaded("bettercombat");
    }

    public void registerRegistries(NewRegistryEvent event) {
        event.register(TRAIT_REGISTRY);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            //LOGGER.info("HELLO FROM CLIENT SETUP");
            //LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
