package br.com.lucasIsrael.androidrecipes.drinks.categories.data.repository

import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.model.DrinkCategories

interface DrinkCategoriesRepository {

    suspend fun getCategories() : ClientResult<DrinkCategories>
}
