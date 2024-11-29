package com.owoentertainment.wolfarmorplus.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.owoentertainment.wolfarmorplus.item.WolfArmorItem;

import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.WolfVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Mixin(Wolf.class)
public abstract class WolfMixin extends TamableAnimal implements NeutralMob, VariantHolder<Holder<WolfVariant>> {
    
    @Shadow
    public abstract boolean hasArmor();
    
    protected WolfMixin(EntityType<? extends TamableAnimal> tamableAnimal, Level level) {
        super(tamableAnimal, level);
    }

    @Inject(method = "mobInteract", at = @At(value = "HEAD"), cancellable = true)
    public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item item = itemStack.getItem();
        if (!this.level().isClientSide()) {
            if (item instanceof WolfArmorItem && this.isOwnedBy(player) && !this.hasArmor() && !this.isBaby()) {
                this.setBodyArmorItem(itemStack.copyWithCount(1));
                itemStack.consume(1, player);
                cir.setReturnValue(InteractionResult.SUCCESS);
            }
            if (ArmorMaterials.ARMADILLO.value().repairIngredient().get().test(itemStack)
                && this.getBodyArmorItem().getItem() instanceof WolfArmorItem    
            ) {
                cir.setReturnValue(InteractionResult.PASS);
            }
        }
    }
    @Inject(method = "hasArmor", at = @At(value = "HEAD"), cancellable = true )
    private void hasArmor(CallbackInfoReturnable<Boolean> cir) {
        if (this.getBodyArmorItem().getItem() instanceof WolfArmorItem) {
            cir.setReturnValue(true);
        }
    }
}
