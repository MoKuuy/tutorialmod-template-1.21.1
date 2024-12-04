package com.bession.tutorialmod.item;
import com.bession.tutorialmod.TutorialMod;
import com.bession.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroup {
    public static final ItemGroup TUTORIAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"tutorial_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.tutorial_group"))
                    .icon(()->new ItemStack(ModItems.ICE_ETHER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ICE_ETHER);
                        entries.add(ModBlocks.Ice_Ether_Block);
                        entries.add(ModItems.PROSPECTOR);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.STRAWBERRY);
                    }).build());

    public static void registerModItemGroup() {

    }
}
