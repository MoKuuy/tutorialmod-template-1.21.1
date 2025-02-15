package com.bession.tutorialmod.tags;
import com.bession.tutorialmod.TutorialMod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {

    public static final TagKey<Block> ORE_LIST = TagKey.of(RegistryKeys.BLOCK,Identifier.of("tutorial", "ore_list"));

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, id));
    }

    public static void  registerMOdBlockTags() {
        TutorialMod.LOGGER.info("Registering Mod Block Tags");
    }
}
