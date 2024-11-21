package com.owoentertainment.wolfarmorplus.inventory;

import javax.annotation.Nonnull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WolfInventory implements Container {

    // Inventory methods
    private final NonNullList<ItemStack> itemStacks = NonNullList.create();
    public NonNullList<ItemStack> getItemStacks() {
        return itemStacks;
    }
    // Container methods
    @Override
    public void clearContent() {
        this.getItemStacks().clear();
    }

    @Override
    public int getContainerSize() {
        return getItemStacks().size();
    }

    @Override
    public boolean isEmpty() {
        return getItemStacks().isEmpty();
    }

    @Override
    public ItemStack getItem(int pSlot) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItem'");
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemNoUpdate'");
    }

    @Override
    public void setItem(int pSlot, @Nonnull ItemStack pStack) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setItem'");
    }

    @Override
    public void setChanged() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setChanged'");
    }

    @Override
    public boolean stillValid(@Nonnull Player pPlayer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stillValid'");
    }
    // ...
}
