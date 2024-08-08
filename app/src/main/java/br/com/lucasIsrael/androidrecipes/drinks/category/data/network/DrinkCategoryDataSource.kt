package br.com.lucasIsrael.androidrecipes.drinks.category.data.network

import br.com.lucasIsrael.androidrecipes.drinks.category.data.model.DrinksCategory

interface DrinkCategoryDataSource {

    suspend fun getCategory(categoryName: String) : DrinksCategory
}
