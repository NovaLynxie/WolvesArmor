package com.owoentertainment.wolfarmorplus.item;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;
import com.owoentertainment.wolfarmorplus.data.WolfArmorData;

import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class WolfArmorItem extends Item {
    private final ResourceLocation armorTexture;
    // main armor item classes
    public WolfArmorItem(WolfArmorData data) {
        //super(new AnimalArmorItem(material, getBodyType(), canRepair, null))
        super(new Item.Properties().stacksTo(1));
        data.getBonus();
        this.armorTexture = WolfArmorPlus.resourceId("textures/entity/wolf/armor/wolf_armor_"+data.getName()+".png");
    }
    public WolfArmorItem(WolfArmorData data, boolean isFireproof) {
        super(new Item.Properties().stacksTo(1));
        data.getBonus();
        this.armorTexture = WolfArmorPlus.resourceId("textures/entity/wolf/armor/wolf_armor_"+data.getName()+".png");
    }
    // client armor item class
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getEntityTextureLocation() {
        return this.armorTexture;
    }
}
