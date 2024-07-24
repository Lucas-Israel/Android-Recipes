package br.com.lucasIsrael.androidrecipes.meals.category.data.network

import br.com.lucasIsrael.androidrecipes.meals.category.data.api.CategoryApiService
import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.core.model.ClientResult
import java.net.ConnectException
import javax.inject.Inject

class CategoryDataSourceImpl @Inject constructor(private val categoryApiService: CategoryApiService) :
    CategoryDataSource {

    override suspend fun getCategory(category: String): ClientResult<Meals> {
        val response = categoryApiService.getCategory(category)
        val responseBody = response.body()

        if (!response.isSuccessful || responseBody == null) {
            return ClientResult.ClientError(response.code(), response.message())
        }

        return ClientResult.ClientSuccess(responseBody)
    }
}