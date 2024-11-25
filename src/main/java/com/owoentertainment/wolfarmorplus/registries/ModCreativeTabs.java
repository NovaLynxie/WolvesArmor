package com.owoentertainment.wolfarmorplus.registries;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WolfArmorPlus.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("wolf_armors", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.wolfarmorplus"))
        .withTabsBefore(net.minecraft.world.item.CreativeModeTabs.COMBAT)
        .displayItems((parameters, output) -> {
            output.accept(ItemRegistry.BONE_WOLF_ARMOR);
            output.accept(ItemRegistry.MOSSY_WOLF_ARMOR);
            output.accept(ItemRegistry.TURTLE_WOLF_ARMOR);
            output.accept(ItemRegistry.LEATHER_WOLF_ARMOR);
            //output.accept(ItemRegistry.COPPER_WOLF_ARMOR);
            output.accept(ItemRegistry.CHAIN_WOLF_ARMOR);
            output.accept(ItemRegistry.IRON_WOLF_ARMOR);
            output.accept(ItemRegistry.CHAIN_WOLF_ARMOR);
            output.accept(ItemRegistry.GOLD_WOLF_ARMOR);
            output.accept(ItemRegistry.DIAMOND_WOLF_ARMOR);
            output.accept(ItemRegistry.NETHERITE_WOLF_ARMOR);
        }).build()
    );
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
