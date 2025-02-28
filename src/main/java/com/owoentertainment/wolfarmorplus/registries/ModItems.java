package com.owoentertainment.wolfarmorplus.registries;

import com.owoentertainment.wolfarmorplus.WolfArmorPlus;
import com.owoentertainment.wolfarmorplus.item.WolfArmorItem;

import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Create item registry for items under mod_id namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WolfArmorPlus.MOD_ID);
    
    // Custom mod items
    //public static final DeferredItem<Item> UPGRADE_BLUEPRINT = ITEMS.registerSimpleItem("upgrade_blueprint");
    
    // Custom wolf armors
    public static final DeferredItem<Item> BONE_WOLF_ARMOR = ITEMS.register("bone_wolf_armor", () -> new WolfArmorItem(
        WolfArmorMaterials.BONE, 2)
    );
    public static final DeferredItem<Item> CHAIN_WOLF_ARMOR = ITEMS.register("chain_wolf_armor", () -> new WolfArmorItem(
        WolfArmorMaterials.CHAIN, 3)
    );
    /* TODO Requires rework to function as unbreakable no protection armor!
    public static final DeferredItem<Item> MOSSY_WOLF_ARMOR = ITEMS.register("mossy_wolf_armor", () -> new WolfArmorItem(
        WolfArmorMaterials.MOSS, 0)
    );
     */
    public static final DeferredItem<Item> TURTLE_WOLF_ARMOR = ITEMS.register("turtle_wolf_armor", () -> new WolfArmorItem(
        ArmorMaterials.TURTLE, 6)
    );
    public static void registerItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
