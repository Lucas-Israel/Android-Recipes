package br.com.lucasIsrael.androidrecipes.meals.data.network

import br.com.lucasIsrael.androidrecipes.meals.data.model.Categories
import br.com.lucasIsrael.androidrecipes.meals.data.model.ClientResult

interface CategoriesDataSource {

    suspend fun getCategories() : ClientResult<Categories>
}