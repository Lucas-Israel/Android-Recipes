package br.com.lucasIsrael.androidrecipes.meals.categories.data.network

import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories
import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.ClientResult

interface CategoriesDataSource {

    suspend fun getCategories() : ClientResult<Categories>
}