package com.owoentertainment.wolfarmorplus.registries;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagsRegistry {
    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(WolfArmorPlus.MODID, name));
        }
    }
}
