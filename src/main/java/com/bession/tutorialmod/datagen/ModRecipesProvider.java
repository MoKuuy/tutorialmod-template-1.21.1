package com.bession.tutorialmod.datagen;

import com.bession.tutorialmod.TutorialMod;
import com.bession.tutorialmod.block.ModBlocks;
import com.bession.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {

    public static final List<ItemConvertible> ICE_ETHER = List.of(Items.ICE);

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //冰以太和冰以太方块的可逆合成
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ICE_ETHER
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.Ice_Ether_Block);

        //冰以太熔炉
        offerSmelting(exporter,ICE_ETHER,RecipeCategory.MISC,ModItems.ICE_ETHER,
                0.7f,200,"ice_ether");
        //冰以太高炉
        offerBlasting(exporter,ICE_ETHER,RecipeCategory.MISC,ModItems.ICE_ETHER,
                0.7f,200,"ice_ether");
        //冰以太营火
        offerFoodCookingRecipe(exporter,"campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                600, Items.ICE,ModItems.ICE_ETHER,0.35f);
        //甜菜根有序生成糖
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR,3)
                .pattern("###")
                .input('#', Ingredient.ofItems(Items.BEETROOT))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID,"beetroot_to_sugar"));
        //矿石探测器的有序生成
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.PROSPECTOR,1)
                .pattern("#A#")
                .pattern("#B#")
                .pattern("#C#")
                .input('#',Ingredient.ofItems(Items.IRON_INGOT))
                .input('A',Ingredient.ofItems(Items.DIAMOND))
                .input('B',Ingredient.ofItems(ModItems.ICE_ETHER))
                .input('C',Ingredient.ofItems(Items.GOLD_INGOT))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter,Identifier.of(TutorialMod.MOD_ID,"prospector"));
    }
}
