package br.com.lucasIsrael.androidrecipes.meals.category.data.api

import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryApiService {

    @GET("filter.php")
    suspend fun getCategory(@Query("c") category: String): Response<Meals>
}