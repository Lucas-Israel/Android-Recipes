package br.com.lucasIsrael.androidrecipes.meals.recipe.data.api

import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {

    @GET("lookup.php")
    suspend fun getRecipe(@Query("i") id: String): Response<Meals>
}