package br.com.lucasIsrael.androidrecipes.meals.categories.data.api

import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories
import retrofit2.Response
import retrofit2.http.GET

interface CategoriesApiService {

    @GET("categories.php")
    suspend fun getCategories(): Response<Categories>
}