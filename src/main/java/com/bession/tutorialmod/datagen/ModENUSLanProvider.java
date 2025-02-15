package com.bession.tutorialmod.datagen;

import com.bession.tutorialmod.block.ModBlocks;
import com.bession.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ICE_ETHER,"Ice Ether");
        translationBuilder.add(ModItems.PROSPECTOR,"Prospector");
        translationBuilder.add(ModItems.CHEESE,"Cheese");
        translationBuilder.add(ModItems.STRAWBERRY,"Strawberry");

        translationBuilder.add(ModBlocks.Ice_Ether_Block,"Ice Ether Block");
        translationBuilder.add("itemGroup.tutorial_group","Tutorial Group");

        translationBuilder.add("item.tutorialmod.prospector.shift_tooltip","A tool used to find ores.");
        translationBuilder.add("item.tutorialmod.prospector.tooltip","Hold \u00A7dSHIFT\u00A7r for more information");
    }
}
