package com.bession.tutorialmod;

import com.bession.tutorialmod.block.ModBlocks;
import com.bession.tutorialmod.item.ModItemGroup;
import com.bession.tutorialmod.item.ModItems;
import com.bession.tutorialmod.tags.ModBlockTags;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModItemGroup.registerModItemGroup();
		ModBlocks.registerModBlock();
		ModBlockTags.registerMOdBlockTags();

	}
}