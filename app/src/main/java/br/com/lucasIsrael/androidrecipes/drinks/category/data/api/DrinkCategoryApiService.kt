package br.com.lucasIsrael.androidrecipes.drinks.category.data.api

import br.com.lucasIsrael.androidrecipes.drinks.category.data.model.DrinksCategory
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkCategoryApiService {

    @GET("filter.php")
    suspend fun getCategory(@Query("c") categoryName: String) : DrinksCategory
}
