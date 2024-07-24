package br.com.lucasIsrael.androidrecipes.meals.category.data.network

import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.core.model.ClientResult

interface CategoryDataSource {

    suspend fun getCategory(category: String): ClientResult<Meals>
}