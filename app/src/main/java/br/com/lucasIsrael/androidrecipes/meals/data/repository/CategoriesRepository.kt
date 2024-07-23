package br.com.lucasIsrael.androidrecipes.meals.data.repository

import br.com.lucasIsrael.androidrecipes.meals.data.model.Categories

interface CategoriesRepository {

    suspend fun getCategories(): Categories
}