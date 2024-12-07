package com.owoentertainment.wolfarmorplus.registries;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class WolfArmorMaterials {
    public static final Holder<ArmorMaterial> BONE = register("bone",
        Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
            attribute.put(ArmorItem.Type.BODY, 2);
        }), 2, 0f, 0.0f, () -> Items.BONE
    );
    //public static final Holder<ArmorMaterial> COPPER = register("copper",
    //    Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
    //        attribute.put(ArmorItem.Type.BODY, 4);
    //    }), 4, 0f, 0.0f, () -> Items.COPPER_INGOT
    //);
    public static final Holder<ArmorMaterial> MOSS = register("moss",
        Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
            attribute.put(ArmorItem.Type.BODY, 0);
        }), 1, 0f, 0.0f, () -> Items.MOSS_BLOCK
    );

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, int enchantability, float toughness, float knockbackResistance, Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(WolfArmorPlus.MOD_ID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_WOLF;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, 
            new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
