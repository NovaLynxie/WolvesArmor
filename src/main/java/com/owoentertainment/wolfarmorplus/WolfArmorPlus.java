package com.owoentertainment.wolfarmorplus;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.owoentertainment.wolfarmorplus.registries.ModCreativeTabs;
import com.owoentertainment.wolfarmorplus.registries.ModItems;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(WolfArmorPlus.MODID)
public class WolfArmorPlus {
    // Define mod id to be used globally throughout the code.
    public static final String MODID = "wolfarmorplus";
    // Define mod logger to be used globally throughout the code.
    public static final Logger LOGGER = LogUtils.getLogger();

    // Main constructor for mod class, this is first run when mod is loaded.
    public WolfArmorPlus(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        NeoForge.EVENT_BUS.register(new EventHandlers());
    }
    public static ResourceLocation resourceId(String name) {
        return ResourceLocation.fromNamespaceAndPath(WolfArmorPlus.MODID, name);
    }
}
