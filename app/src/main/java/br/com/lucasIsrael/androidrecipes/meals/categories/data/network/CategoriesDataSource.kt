package br.com.lucasIsrael.androidrecipes.meals.categories.data.network

import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories

interface CategoriesDataSource {

    suspend fun getCategories() : Categories
}
