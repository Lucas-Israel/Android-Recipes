package br.com.lucasIsrael.androidrecipes.meals.recipe.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasIsrael.androidrecipes.common.coroutines.safeApiCall
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.network.RecipeDataSource
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val recipeDataSource: RecipeDataSource) :
    RecipeRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getRecipe(id: String): ClientResult<Meals> {
        return safeApiCall {
            recipeDataSource.getRecipe(id)
        }
    }
}
