package br.com.lucasIsrael.androidrecipes.meals.recipe.data.network

import br.com.lucasIsrael.androidrecipes.meals.recipe.data.api.RecipeApiService
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals
import javax.inject.Inject

class RecipeDataSourceImpl @Inject constructor(private val recipeApiService: RecipeApiService) :
    RecipeDataSource {

    override suspend fun getRecipe(id: String): Meals {
        return recipeApiService.getRecipe(id)
    }
}
