package br.com.lucasIsrael.androidrecipes.meals.categories.data.network

import br.com.lucasIsrael.androidrecipes.meals.categories.data.api.CategoriesApiService
import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories
import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.ClientResult
import javax.inject.Inject

class CategoriesDataSourceImpl @Inject constructor(private val categoriesApiService: CategoriesApiService) :
    CategoriesDataSource {

    override suspend fun getCategories(): ClientResult<Categories> {
        val response = categoriesApiService.getCategories()
        val responseBody = response.body()

        if (!response.isSuccessful || responseBody == null) {
            return ClientResult.ClientError(response.code(), response.message())
        }

        return ClientResult.ClientSuccess(responseBody)
    }

}