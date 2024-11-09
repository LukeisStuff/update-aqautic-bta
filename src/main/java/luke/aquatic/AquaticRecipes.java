package luke.aquatic;

import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.aquatic.AquaticMod.MOD_ID;

public class AquaticRecipes implements RecipeEntrypoint {

	public void initializeRecipes() {

		RecipeBuilderShaped templateLogtoPlank = new RecipeBuilderShaped(MOD_ID, "X");
		templateLogtoPlank.addInput('X', AquaticBlocks.logStrippedOak).create("stripped_log_oak_to_planks", new ItemStack(Block.planksOak, 4));
		templateLogtoPlank.addInput('X', AquaticBlocks.logStrippedPine).create("stripped_log_pine_to_planks", new ItemStack(Block.planksOakPainted, 4, 12));
		templateLogtoPlank.addInput('X', AquaticBlocks.logStrippedBirch).create("stripped_log_birch_to_planks", new ItemStack(Block.planksOakPainted, 4, 0));
		templateLogtoPlank.addInput('X', AquaticBlocks.logStrippedCherry).create("stripped_log_cherry_to_planks", new ItemStack(Block.planksOakPainted, 4, 6));
		templateLogtoPlank.addInput('X', AquaticBlocks.logStrippedEucalyptus).create("stripped_log_eucalyptus_to_planks", new ItemStack(Block.planksOakPainted, 4, 1));
		templateLogtoPlank.addInput('X', AquaticBlocks.logStrippedOakMossy).create("stripped_log_oak_mossy_to_planks", new ItemStack(Block.planksOakPainted, 4, 13));
		templateLogtoPlank.addInput('X', AquaticBlocks.logStrippedThorn).create("stripped_log_thorn_to_planks", new ItemStack(Block.planksOakPainted, 4, 14));
		templateLogtoPlank.addInput('X', AquaticBlocks.logStrippedPalm).create("stripped_log_palm_to_planks", new ItemStack(Block.planksOakPainted, 4, 4));

		templateLogtoPlank.addInput('X', AquaticBlocks.woodStrippedOak).create("stripped_wood_oak_to_planks", new ItemStack(Block.planksOak, 4));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodStrippedPine).create("stripped_wood_pine_to_planks", new ItemStack(Block.planksOakPainted, 4, 12));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodStrippedBirch).create("stripped_wood_birch_to_planks", new ItemStack(Block.planksOakPainted, 4, 0));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodStrippedCherry).create("stripped_wood_cherry_to_planks", new ItemStack(Block.planksOakPainted, 4, 6));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodStrippedEucalyptus).create("stripped_wood_eucalyptus_to_planks", new ItemStack(Block.planksOakPainted, 4, 1));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodStrippedOakMossy).create("stripped_wood_oak_mossy_to_planks", new ItemStack(Block.planksOakPainted, 4, 13));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodStrippedThorn).create("stripped_wood_thorn_to_planks", new ItemStack(Block.planksOakPainted, 4, 14));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodStrippedPalm).create("stripped_wood_palm_to_planks", new ItemStack(Block.planksOakPainted, 4, 4));

		templateLogtoPlank.addInput('X', AquaticBlocks.woodOak).create("wood_oak_to_planks", new ItemStack(Block.planksOak, 4));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodPine).create("wood_pine_to_planks", new ItemStack(Block.planksOakPainted, 4, 12));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodBirch).create("wood_birch_to_planks", new ItemStack(Block.planksOakPainted, 4, 0));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodCherry).create("wood_cherry_to_planks", new ItemStack(Block.planksOakPainted, 4, 6));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodEucalyptus).create("wood_eucalyptus_to_planks", new ItemStack(Block.planksOakPainted, 4, 1));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodOakMossy).create("wood_oak_mossy_to_planks", new ItemStack(Block.planksOakPainted, 4, 13));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodThorn).create("wood_thorn_to_planks", new ItemStack(Block.planksOakPainted, 4, 14));
		templateLogtoPlank.addInput('X', AquaticBlocks.woodPalm).create("wood_palm_to_planks", new ItemStack(Block.planksOakPainted, 4, 4));



		RecipeBuilderShaped templateBricks = new RecipeBuilderShaped(MOD_ID, "XX", "XX");
		templateBricks.addInput('X', Block.logOak).create("wood_oak", new ItemStack(AquaticBlocks.woodOak, 4));
		templateBricks.addInput('X', Block.logPine).create("wood_pine", new ItemStack(AquaticBlocks.woodPine, 4));
		templateBricks.addInput('X', Block.logBirch).create("wood_birch", new ItemStack(AquaticBlocks.woodBirch, 4));
		templateBricks.addInput('X', Block.logCherry).create("wood_cherry", new ItemStack(AquaticBlocks.woodCherry, 4));
		templateBricks.addInput('X', Block.logEucalyptus).create("wood_eucalyptus", new ItemStack(AquaticBlocks.woodEucalyptus, 4));
		templateBricks.addInput('X', Block.logOakMossy).create("wood_oak_mossy", new ItemStack(AquaticBlocks.woodOakMossy, 4));
		templateBricks.addInput('X', Block.logThorn).create("wood_thorn", new ItemStack(AquaticBlocks.woodThorn, 4));
		templateBricks.addInput('X', Block.logPalm).create("wood_palm", new ItemStack(AquaticBlocks.woodPalm, 4));



		RecipeBuilder.initNameSpace(MOD_ID);
	}
	@Override
	public void onRecipesReady() {
		initializeRecipes();
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
		RecipeBuilder.getRecipeNamespace(MOD_ID);


	}
}
