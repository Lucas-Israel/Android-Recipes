package br.com.lucasIsrael.androidrecipes.meals.categories.data.repository

import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories

interface CategoriesRepository {

    suspend fun getCategories(): Categories
}