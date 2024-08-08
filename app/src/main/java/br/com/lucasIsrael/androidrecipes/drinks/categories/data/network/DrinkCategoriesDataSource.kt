package br.com.lucasIsrael.androidrecipes.drinks.categories.data.network

import br.com.lucasIsrael.androidrecipes.drinks.categories.data.model.DrinkCategories

interface DrinkCategoriesDataSource {

    suspend fun getCategories() : DrinkCategories
}
