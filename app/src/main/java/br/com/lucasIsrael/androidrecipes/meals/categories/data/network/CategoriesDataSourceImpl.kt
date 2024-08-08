package br.com.lucasIsrael.androidrecipes.meals.categories.data.network

import br.com.lucasIsrael.androidrecipes.meals.categories.data.api.CategoriesApiService
import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories
import javax.inject.Inject

class CategoriesDataSourceImpl @Inject constructor(private val categoriesApiService: CategoriesApiService) :
    CategoriesDataSource {

    override suspend fun getCategories(): Categories {
        return categoriesApiService.getCategories()
    }

}
