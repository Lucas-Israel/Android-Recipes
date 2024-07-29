package br.com.lucasIsrael.androidrecipes.meals.recipe.data.network

import br.com.lucasIsrael.androidrecipes.meals.core.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.api.RecipeApiService
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals
import javax.inject.Inject

class RecipeDataSourceImpl @Inject constructor(private val recipeApiService: RecipeApiService) :
    RecipeDataSource {

    override suspend fun getRecipe(id: String): ClientResult<Meals> {
        val response = recipeApiService.getRecipe(id)
        val responseBody = response.body()

        if (!response.isSuccessful || responseBody == null) {
            return ClientResult.ClientError(response.code(), response.message())
        }

        return ClientResult.ClientSuccess(responseBody)
    }
}