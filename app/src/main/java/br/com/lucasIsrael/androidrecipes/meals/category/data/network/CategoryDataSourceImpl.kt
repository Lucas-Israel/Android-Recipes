package br.com.lucasIsrael.androidrecipes.meals.category.data.network

import br.com.lucasIsrael.androidrecipes.meals.category.data.api.CategoryApiService
import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import javax.inject.Inject

class CategoryDataSourceImpl @Inject constructor(private val categoryApiService: CategoryApiService) :
    CategoryDataSource {

    override suspend fun getCategory(category: String): Meals {
        return categoryApiService.getCategory(category)
    }
}
