package com.owoentertainment.wolfarmorplus;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.owoentertainment.wolfarmorplus.registries.ModCreativeTabs;
import com.owoentertainment.wolfarmorplus.registries.ModItems;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(WolfArmorPlus.MODID)
public class WolfArmorPlus {
    // Define mod id to be used globally throughout the code.
    public static final String MODID = "wolfarmorplus";
    // Define mod logger to be used globally throughout the code.
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public static ResourceLocation resourceId(String name) { // unused?
        return ResourceLocation.fromNamespaceAndPath(WolfArmorPlus.MODID, name);
    }
    // Main constructor for mod class, this is first run when mod is loaded.
    public WolfArmorPlus(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
        ModCreativeTabs.register(modEventBus);
        ModItems.register(modEventBus);
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Dusting off the wolf armors. Protecting your trusty canine companions!");
    }
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            
        }
    }
}
