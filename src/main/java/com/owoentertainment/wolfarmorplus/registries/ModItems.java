package com.owoentertainment.wolfarmorplus.registries;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;
import com.owoentertainment.wolfarmorplus.item.WolfArmorItem;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Create item registry for items under mod_id namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WolfArmorPlus.MOD_ID);
    
    // Custom mod items
    public static final DeferredItem<Item> UPGRADE_BLUEPRINT = ITEMS.registerSimpleItem("upgrade_blueprint");
    
    // Custom wolf armors
    public static final DeferredItem<Item> BONE_WOLF_ARMOR = ITEMS.register("bone_wolf_armor", () -> new WolfArmorItem(
        WolfArmorMaterials.BONE, new Item.Properties().durability(ArmorItem.Type.BODY.getDurability(2)).stacksTo(1))
    );
    public static final DeferredItem<Item> CHAIN_WOLF_ARMOR = ITEMS.register("chain_wolf_armor", () -> new WolfArmorItem(
        WolfArmorMaterials.CHAIN, new Item.Properties().durability(ArmorItem.Type.BODY.getDurability(3)).stacksTo(1))
    );
    public static final DeferredItem<Item> MOSSY_WOLF_ARMOR = ITEMS.register("mossy_wolf_armor", () -> new WolfArmorItem(
        WolfArmorMaterials.MOSS, new Item.Properties().stacksTo(1))
    );
    public static final DeferredItem<Item> TURTLE_WOLF_ARMOR = ITEMS.register("turtle_wolf_armor", () -> new WolfArmorItem(
        ArmorMaterials.TURTLE, new Item.Properties().durability(ArmorItem.Type.BODY.getDurability(6)).stacksTo(1))
    );
    public static void registerItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
