package com.owoentertainment.wolfarmorplus.api;

import net.minecraft.world.item.ItemStack;

public interface WolfArmorAccessor { 
    // Code crashes here calling wolf to accessor, workaround required
    ItemStack getWolfArmor();
    void setWolfArmor(ItemStack stack);
}