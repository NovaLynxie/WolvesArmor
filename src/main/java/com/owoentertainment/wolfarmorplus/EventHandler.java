package com.owoentertainment.wolfarmorplus;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
//import net.minecraft.entity.passive.WolfEntity; // missing or no longer exists in newer builds
//import net.minecraft.entity.player.PlayerEntity; // missing or no longer exists in newer builds
//import net.minecraft.world.World; // missing or no longer exists in newer builds

public class EventHandler {
    @SubscribeEvent
    public void interactWolf(PlayerInteractEvent.EntityInteractSpecific event) {
        // get player entity from interact event
        Player player = event.getEntity();
        // Check if entity interacted with is a wolf entity.
        if (event.getTarget() instanceof Wolf) {
            // if true, get entity data
            Wolf wolf = (Wolf) event.getTarget();
            // Check if wolf is owned by player, but first check if wolf owner uuid is not null.
            if (wolf.getOwnerUUID() != null) {
                if (wolf.getOwnerUUID().equals(player.getUUID())) {
                    // TODO: Implement WolfArmorAccessor API
                    WolfArmorPlus.LOGGER.debug("Player owns wolf!");
                }
            }
        }
    }
}
