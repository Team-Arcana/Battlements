package net.teamarcana.battlements;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
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
    public static final Logger LOGGER = LogUtils.getLogger();
    public static boolean isBetterCombatHere;
    public static boolean isLegendaryTooltipsHere;
    public static final ResourceLocation FONT_ICONS = ResourceLocation.fromNamespaceAndPath(MOD_ID, "icons");

    public Battlements(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        BattleBlocks.register(modEventBus);
        BattleItems.register(modEventBus);
        BattleEnchantmentEntityEffects.register(modEventBus);
        BattleMobEffects.register(modEventBus);
        BattlePotions.register(modEventBus);

        BattleCreativeTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static boolean isBetterCombatHere(){
        return isBetterCombatHere;
    }
    public static boolean isLegendaryTooltipsHere() { return isLegendaryTooltipsHere; }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        isBetterCombatHere = ModList.get().isLoaded("bettercombat");
        isLegendaryTooltipsHere = ModList.get().isLoaded("legendarytooltips");
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
