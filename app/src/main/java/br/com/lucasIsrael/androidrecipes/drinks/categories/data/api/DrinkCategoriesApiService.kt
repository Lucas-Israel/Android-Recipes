package br.com.lucasIsrael.androidrecipes.drinks.categories.data.api

import br.com.lucasIsrael.androidrecipes.drinks.categories.data.model.DrinkCategories
import retrofit2.http.GET

interface DrinkCategoriesApiService {

    @GET("list.php?c=list")
    suspend fun getCategories(): DrinkCategories
}
