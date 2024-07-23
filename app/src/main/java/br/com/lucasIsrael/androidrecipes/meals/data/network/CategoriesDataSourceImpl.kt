package br.com.lucasIsrael.androidrecipes.meals.data.network

import br.com.lucasIsrael.androidrecipes.meals.data.api.ApiService
import br.com.lucasIsrael.androidrecipes.meals.data.model.Categories
import br.com.lucasIsrael.androidrecipes.meals.data.model.ClientResult
import javax.inject.Inject

class CategoriesDataSourceImpl @Inject constructor(private val apiService: ApiService) : CategoriesDataSource {

    override suspend fun getCategories(): ClientResult<Categories> {
        val response = apiService.getCategories()
        val responseBody = response.body()

        if (!response.isSuccessful || responseBody == null) {
            return ClientResult.ClientError(response.code(), response.message())
        }

        return ClientResult.ClientSuccess(responseBody)
    }

}