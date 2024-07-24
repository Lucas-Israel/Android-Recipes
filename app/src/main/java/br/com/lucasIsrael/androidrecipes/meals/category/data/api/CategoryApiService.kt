package br.com.lucasIsrael.androidrecipes.meals.category.data.api

import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryApiService {

    @GET("filter.php?c={category}")
    suspend fun getCategory(@Path("category") category: String): Response<Meals>
}