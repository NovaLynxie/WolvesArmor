package com.owoentertainment.wolfarmorplus.datagen;

import java.util.LinkedHashMap;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;
import com.owoentertainment.wolfarmorplus.registries.ItemRegistry;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
//import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
//import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WolfArmorPlus.MODID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        basicItem(ItemRegistry.BONE_WOLF_ARMOR.get());
        basicItem(ItemRegistry.CHAIN_WOLF_ARMOR.get());
        //basicItem(ItemRegistry.COPPER_WOLF_ARMOR.get());
        basicItem(ItemRegistry.DIAMOND_WOLF_ARMOR.get());
        basicItem(ItemRegistry.GOLD_WOLF_ARMOR.get());
        basicItem(ItemRegistry.IRON_WOLF_ARMOR.get());
        basicItem(ItemRegistry.LEATHER_WOLF_ARMOR.get());
        basicItem(ItemRegistry.MOSSY_WOLF_ARMOR.get());
        basicItem(ItemRegistry.NETHERITE_WOLF_ARMOR.get());
        basicItem(ItemRegistry.TURTLE_WOLF_ARMOR.get());
    }
}
