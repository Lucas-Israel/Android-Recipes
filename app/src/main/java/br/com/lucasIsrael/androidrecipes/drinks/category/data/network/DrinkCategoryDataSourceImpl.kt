package br.com.lucasIsrael.androidrecipes.drinks.category.data.network

import br.com.lucasIsrael.androidrecipes.drinks.category.data.api.DrinkCategoryApiService
import br.com.lucasIsrael.androidrecipes.drinks.category.data.model.DrinksCategory
import javax.inject.Inject

class DrinkCategoryDataSourceImpl @Inject constructor(private val apiService: DrinkCategoryApiService) :
    DrinkCategoryDataSource {

    override suspend fun getCategory(categoryName: String): DrinksCategory {
        return apiService.getCategory(categoryName)
    }
}
