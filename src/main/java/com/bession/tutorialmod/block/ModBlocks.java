package com.bession.tutorialmod.block;
import com.bession.tutorialmod.TutorialMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block Ice_Ether_Block = registerBlock("ice_ether_block",
            new Block(AbstractBlock.Settings.create().strength(3.0f,3.0f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,Identifier.of(TutorialMod.MOD_ID,name),block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID,name),
                new BlockItem(block,new Item.Settings()));
    }

    public static void registerModBlock() {

    }
}
