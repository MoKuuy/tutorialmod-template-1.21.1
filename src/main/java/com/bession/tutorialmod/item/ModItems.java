package com.bession.tutorialmod.item;

import com.bession.tutorialmod.TutorialMod;

import com.bession.tutorialmod.item.custom.Prospector;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item ICE_ETHER = registerItem("ice_ether",new Item(new Item.Settings()));

    public static final Item PROSPECTOR = registerItem("prospector",new Prospector(new Item.Settings().maxDamage(64)));

    private static void addItemsToIG(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(ICE_ETHER);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM,Identifier.of(TutorialMod.MOD_ID,name),item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIG);
    }
}
