package luke.aquatic;

import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.aquatic.AquaticMod.MOD_ID;

public class AquaticRecipes implements RecipeEntrypoint {

	public void initializeRecipes() {

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
