package br.com.lucasIsrael.androidrecipes.meals.recipe.data.repository

import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals

interface RecipeRepository {

    suspend fun getRecipe(id: String): ClientResult<Meals>
}
