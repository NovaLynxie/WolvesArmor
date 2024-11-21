package com.owoentertainment.wolfarmorplus;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;

public class EventHandlers {
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
            // Check if wolf is owned by player, but first check if wolf owner uuid is not null.
            if (wolf.getOwnerUUID() != null) {
                if (wolf.getOwnerUUID().equals(player.getUUID())) {
                    WolfArmorPlus.LOGGER.debug("Detected wolf owner interaction!");
                    // TODO: Implement Wolf Armor Inventory
                    wolf.stopInPlace();
                    if (wolf.isInSittingPose()) {
                        wolf.setInSittingPose(true);
                    }
                    // check if the wolf has armor equipped or if player has armor item in hand
                    if (!wolf.isWearingBodyArmor() && player.getMainHandItem().getItem() instanceof AnimalArmorItem) {
                        WolfArmorPlus.LOGGER.debug("Detected AnimalArmorItem in player's hand! Attempting to equip animal armor item.");
                        if (!worldLevel.isClientSide) {
                            wolf.setBodyArmorItem(player.getMainHandItem());
                            if (!player.isCreative()) {
                                player.setItemInHand(player.getUsedItemHand(), ItemStack.EMPTY);
                            }
                        }
                    } else
                    if (wolf.isWearingBodyArmor() && player.getMainHandItem().getItem() instanceof ShearsItem) {
                        WolfArmorPlus.LOGGER.debug("Detected ShearsItem in player's hand! Attempting to remove animal armor item.");
                        if (!worldLevel.isClientSide) {
                            wolf.dropPreservedEquipment();
                        }
                    }
                }
            }
        }
    }
}
