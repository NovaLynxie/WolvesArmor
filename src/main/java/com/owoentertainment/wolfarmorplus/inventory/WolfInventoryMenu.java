package com.owoentertainment.wolfarmorplus.inventory;

import javax.annotation.Nonnull;

import net.minecraft.world.Container;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class WolfInventoryMenu extends AbstractContainerMenu {
    private final Container wolfContainer;
    private final Wolf wolf;

    public WolfInventoryMenu(int id, Inventory playerInventory, Container container, final Wolf wolf) {
        super((MenuType<?>) null, id);
        this.wolfContainer = container;
        this.wolf = wolf;
        int index = 3;
        this.addSlot(new Slot(container, 0, 8, 18) {
            // ...
        });
        this.addSlot(new Slot(container, 1, 8, 16) {
            // ...
        });
    }

    @Override
    public ItemStack quickMoveStack(@Nonnull Player player, int slot) {
        ItemStack stack = ItemStack.EMPTY;
        //Slot wolfInvSlot = this.

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quickMoveStack'");
    }

    @Override
    public boolean stillValid(@Nonnull Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stillValid'");
    }
}
