package com.owoentertainment.wolfarmorplus;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import com.owoentertainment.wolfarmorplus.api.WolfArmorAccessor;
import com.owoentertainment.wolfarmorplus.item.WolfArmorItem;

import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level; 

public class EventHandlers {
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
                    WolfArmorAccessor wolfComponent = WolfArmorPlus.getAccessor(wolf);
                    // check if the wolf has armor equipped or if player has armor item in hand
                    if (wolfComponent.getWolfArmor().isEmpty() && player.getMainHandItem().getItem() instanceof WolfArmorItem) {
                        if (!worldLevel.isClientSide) {
                            // ...
                        }
                    } else
                    if (!wolfComponent.getWolfArmor().isEmpty() && (player.getMainHandItem().isEmpty() && player.isCrouching())) {
                        if (!worldLevel.isClientSide) {
                            // ...
                        }
                    }
                }
            }
        }
    }
}
