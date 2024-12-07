package com.owoentertainment.wolfarmorplus.registries;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, WolfArmorPlus.MOD_ID);

    public static void registerMenus(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
