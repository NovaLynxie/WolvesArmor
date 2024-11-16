package com.owoentertainment.wolfarmorplus.api;

import net.minecraft.world.item.ItemStack;

public interface WolfArmorAccessor {
    ItemStack getArmorItemStack();
    void setArmor(ItemStack stack);
}