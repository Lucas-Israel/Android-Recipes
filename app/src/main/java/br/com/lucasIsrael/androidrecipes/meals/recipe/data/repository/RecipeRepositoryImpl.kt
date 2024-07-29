package br.com.lucasIsrael.androidrecipes.meals.recipe.data.repository

import br.com.lucasIsrael.androidrecipes.meals.core.coroutines.DispatcherProvider
import br.com.lucasIsrael.androidrecipes.meals.core.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.network.RecipeDataSource
import kotlinx.coroutines.withContext
import java.net.ConnectException
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val recipeDataSource: RecipeDataSource) :
    RecipeRepository {

    override suspend fun getRecipe(id: String): Meals {
        lateinit var payload: Meals

        withContext(DispatcherProvider.IO) {

            val response = recipeDataSource.getRecipe(id)

            if (response is ClientResult.ClientSuccess) {
                payload = response.data
            }

            if (response is ClientResult.ClientError) {
                throw ConnectException(response.errorMessage)
            }
        }

        return payload
    }
}