package br.com.lucasIsrael.androidrecipes.meals.category.data.network

import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals

interface CategoryDataSource {

    suspend fun getCategory(category: String): Meals
}
