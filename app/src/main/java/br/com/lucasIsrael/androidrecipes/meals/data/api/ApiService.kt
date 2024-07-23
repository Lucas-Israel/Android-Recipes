package br.com.lucasIsrael.androidrecipes.meals.data.api

import br.com.lucasIsrael.androidrecipes.meals.data.model.Categories
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): Response<Categories>
}