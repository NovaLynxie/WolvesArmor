package com.owoentertainment.wolfarmorplus;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.owoentertainment.wolfarmorplus.api.WolfArmorAccessor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(WolfArmorPlus.MOD_ID)
public class WolfArmorPlus {
    // Define mod id to be used globally throughout the code.
    public static final String MOD_ID = "wolfarmorplus";
    // Define mod logger to be used globally throughout the code.
    public static final Logger LOGGER = LogUtils.getLogger();

    // Create Deferred Registers

    // Main constructor for mod class, this is first run when mod is loaded.
    public WolfArmorPlus(IEventBus modEventBus, ModContainer modContainer) {
        // Register mod events here.
        NeoForge.EVENT_BUS.register(new EventHandlers());
    }
    public static WolfArmorAccessor getAccessor(Wolf wolf) {
        return ((WolfArmorAccessor) wolf);
    }
    public static ResourceLocation resourceId(String name) {
        return ResourceLocation.fromNamespaceAndPath(WolfArmorPlus.MOD_ID, name);
    }
}
