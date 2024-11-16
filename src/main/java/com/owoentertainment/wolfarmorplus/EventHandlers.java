package com.owoentertainment.wolfarmorplus;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
//import net.minecraft.entity.passive.WolfEntity; // missing or no longer exists in newer builds
//import net.minecraft.entity.player.PlayerEntity; // missing or no longer exists in newer builds
//import net.minecraft.world.World; // missing or no longer exists in newer builds

public class EventHandlers {
    @SubscribeEvent
    public void interactWolf(PlayerInteractEvent.EntityInteractSpecific event) {
        // get player entity from interact event
        Player player = event.getEntity();
        //PlayerEntity player = event.getTarget();
    }
}
