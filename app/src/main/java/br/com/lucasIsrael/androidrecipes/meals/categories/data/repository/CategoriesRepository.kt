package br.com.lucasIsrael.androidrecipes.meals.categories.data.repository

import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult

interface CategoriesRepository {

    suspend fun getCategories(): ClientResult<Categories>
}
