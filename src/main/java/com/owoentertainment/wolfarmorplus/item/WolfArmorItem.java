package com.owoentertainment.wolfarmorplus.item;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class WolfArmorItem extends AnimalArmorItem {
    private final ResourceLocation textureLocation;

    public WolfArmorItem(Holder<ArmorMaterial> armorMaterial, int armorDurabilityFactor) {
        //super(armorMaterial, BodyType.CANINE, true, properties);
        super (armorMaterial, BodyType.CANINE, true, new Item.Properties().durability(ArmorItem.Type.BODY.getDurability(armorDurabilityFactor)).stacksTo(1));
        String materialHolderName = armorMaterial.getRegisteredName();
        ResourceLocation resourceLocation = getArmorTexture(materialHolderName.substring(materialHolderName.lastIndexOf(":") + 1));
        WolfArmorPlus.LOGGER.debug(resourceLocation.toString());
        this.textureLocation = resourceLocation.withSuffix(".png");
    }
    @Override
    public ResourceLocation getTexture() {
        return this.textureLocation; // get mod's custom armor texture instead
    }

    public ResourceLocation getArmorTexture(String materialName) {
        String armorTexture = "textures/entity/wolf/wolf_armor_"+ materialName;
        return ResourceLocation.fromNamespaceAndPath(WolfArmorPlus.MOD_ID, armorTexture);
    }
}
