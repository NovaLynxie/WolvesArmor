package com.owoentertainment.wolfarmorplus;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.owoentertainment.wolfarmorplus.registries.ItemRegistry;
import com.owoentertainment.wolfarmorplus.registries.ModCreativeTabs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
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
        ItemRegistry.register(modEventBus);
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Dusting off the wolf armors. Protecting your trusty canine companions!");
    }
    // Wolf interaction event.
    @SuppressWarnings("null")
    @SubscribeEvent
    public void interactWolf(PlayerInteractEvent.EntityInteractSpecific event) {
        // Get required information from the interact event
        Player player = event.getEntity(); // get player entity data
        Level worldLevel = event.getLevel(); // get world level data
        // Check if entity interacted with is a wolf entity.
        if (event.getTarget() instanceof Wolf) {
            // if true, get wolf entity data
            Wolf wolf = (Wolf) event.getTarget();
            if (wolf.isOwnedBy(player)) {
                WolfArmorPlus.LOGGER.debug("Detected wolf owner interaction!");
                // get item in player's hand
                ItemStack handItem = player.getItemInHand(player.getUsedItemHand());
                // check if the wolf has armor equipped or if player has armor item in hand
                if (!wolf.isWearingBodyArmor() && handItem.getItem() instanceof AnimalArmorItem) {
                    WolfArmorPlus.LOGGER.debug("Detected AnimalArmorItem in player's hand! Attempting to equip animal armor item.");
                    if (!worldLevel.isClientSide) {
                        wolf.setBodyArmorItem(handItem.copyWithCount(1));
                        if (!player.isCreative()) {
                            handItem.consume(1, player);
                            //player.setItemInHand(player.getUsedItemHand(), ItemStack.EMPTY);
                        }
                    }
                } else
                if (wolf.isWearingBodyArmor() && handItem.getItem().canPerformAction(handItem, ItemAbilities.SHEARS_REMOVE_ARMOR)) {
                    WolfArmorPlus.LOGGER.debug("Detected ShearsItem in player's hand! Attempting to remove animal armor item.");
                    if (!worldLevel.isClientSide) {
                        wolf.playSound(SoundEvents.ARMOR_UNEQUIP_WOLF);
                        wolf.dropPreservedEquipment();
                    }
                }
            }
        }
    }
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            
        }
    }
}
