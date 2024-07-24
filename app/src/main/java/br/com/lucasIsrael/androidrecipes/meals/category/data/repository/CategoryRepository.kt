package br.com.lucasIsrael.androidrecipes.meals.category.data.repository

import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals

interface CategoryRepository {

    suspend fun getCategory(category: String): Meals
}