package com.owoentertainment.wolfarmorplus.registries;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;

import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Create item registry for items under mod_id namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WolfArmorPlus.MODID);
    // Register our armor items here
    public static final DeferredItem<Item> LEATHER_WOLF_ARMOR = ITEMS.register("leather_wolf_armor", () -> new AnimalArmorItem(
        ArmorMaterials.LEATHER, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(24).stacksTo(1))
    );
    public static final DeferredItem<Item> MOSS_WOLF_ARMOR = ITEMS.register("mossy_wolf_armor", () -> new AnimalArmorItem(
        WolfArmorMaterials.MOSS, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().stacksTo(1))
    );
    public static final DeferredItem<Item> BONE_WOLF_ARMOR = ITEMS.register("bone_wolf_armor", () -> new AnimalArmorItem(
        WolfArmorMaterials.BONE, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(32).stacksTo(1))
    );
    public static final DeferredItem<Item> COPPER_WOLF_ARMOR = ITEMS.register("copper_wolf_armor", () -> new AnimalArmorItem(
        WolfArmorMaterials.COPPER, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(48).stacksTo(1))
    );
    public static final DeferredItem<Item> TURTLE_WOLF_ARMOR = ITEMS.register("turtle_wolf_armor", () -> new AnimalArmorItem(
        ArmorMaterials.TURTLE, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(128).stacksTo(1))
    );
    public static final DeferredItem<Item> IRON_WOLF_ARMOR = ITEMS.register("iron_wolf_armor", () -> new AnimalArmorItem(
        ArmorMaterials.IRON, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(72).stacksTo(1))
    );
    public static final DeferredItem<Item> CHAIN_WOLF_ARMOR = ITEMS.register("chain_wolf_armor", () -> new AnimalArmorItem(
        ArmorMaterials.CHAIN, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(48).stacksTo(1))
    );
    public static final DeferredItem<Item> GOLD_WOLF_ARMOR = ITEMS.register("gold_wolf_armor", () -> new AnimalArmorItem(
        ArmorMaterials.GOLD, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(16).stacksTo(1))
    );
    public static final DeferredItem<Item> DIAMOND_WOLF_ARMOR = ITEMS.register("diamond_wolf_armor", () -> new AnimalArmorItem(
        ArmorMaterials.DIAMOND, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(256).stacksTo(1))
    );
    public static final DeferredItem<Item> NETHERITE_WOLF_ARMOR = ITEMS.register("netherite_wolf_armor", () -> new AnimalArmorItem(
        ArmorMaterials.NETHERITE, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(512).stacksTo(1))
    );
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
