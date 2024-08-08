package br.com.lucasIsrael.androidrecipes.drinks.category.data.repository

import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.drinks.category.data.model.DrinksCategory

interface DrinkCategoryRepository {

    suspend fun getCategory(drinkCategory: String): ClientResult<DrinksCategory>
}
