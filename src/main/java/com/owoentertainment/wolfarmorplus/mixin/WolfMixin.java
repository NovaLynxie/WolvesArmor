package com.owoentertainment.wolfarmorplus.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.WolfVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Mixin(Wolf.class)
public abstract class WolfMixin extends TamableAnimal implements NeutralMob, VariantHolder<Holder<WolfVariant>> {

    @Unique
    private final SimpleContainer wolfInventory = new SimpleContainer(9);
    
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
            if (this.isOwnedBy(player) && player.isCrouching()) {
                // TODO Implement wolf inventory persistence
            }
            if (this.hasArmor()) {
                ItemStack armorStack = this.getBodyArmorItem();
                if (this.isInSittingPose() && armorStack.isDamaged() && armorStack.getItem() instanceof AnimalArmorItem animalArmorItem) {
                    if (animalArmorItem.getMaterial().value().repairIngredient().get().test(itemStack)) {
                        itemStack.shrink(1);
                        this.playSound(SoundEvents.WOLF_ARMOR_REPAIR);
                        int repairValue = (int)((float)armorStack.getMaxDamage() * 0.125F);
                        armorStack.setDamageValue(armorStack.getDamageValue() - repairValue);
                    }
                }
            } else if (item instanceof AnimalArmorItem animalArmorItem) {
                if (animalArmorItem.getBodyType() == AnimalArmorItem.BodyType.CANINE
                    && !this.hasArmor() && !this.isBaby() && this.isOwnedBy(player)
                ) {
                    this.setBodyArmorItem(itemStack.copyWithCount(1));
                    itemStack.consume(1, player);
                    cir.setReturnValue(InteractionResult.SUCCESS);
                }
            }
        }
    }
    @Inject(method = "hasArmor", at = @At(value = "HEAD"), cancellable = true)
    private void hasArmor(CallbackInfoReturnable<Boolean> cir) {
        if (this.getBodyArmorItem().getItem() instanceof AnimalArmorItem) {
            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }
    }
}
