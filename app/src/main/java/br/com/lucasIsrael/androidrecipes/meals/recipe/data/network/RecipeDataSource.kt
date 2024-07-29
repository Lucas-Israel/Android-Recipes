package br.com.lucasIsrael.androidrecipes.meals.recipe.data.network

import br.com.lucasIsrael.androidrecipes.meals.core.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals

interface RecipeDataSource {

    suspend fun getRecipe(id: String): ClientResult<Meals>
}