package br.com.lucasIsrael.androidrecipes.drinks.categories.data.network

import br.com.lucasIsrael.androidrecipes.drinks.categories.data.api.DrinkCategoriesApiService
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.model.DrinkCategories
import javax.inject.Inject

class DrinkCategoriesDataSourceImpl @Inject constructor(private val apiService: DrinkCategoriesApiService) :
    DrinkCategoriesDataSource {

    override suspend fun getCategories(): DrinkCategories {
        return apiService.getCategories()
    }
}
