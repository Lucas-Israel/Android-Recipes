package br.com.lucasIsrael.androidrecipes.meals.category.data.repository

import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.category.data.network.CategoryDataSource
import br.com.lucasIsrael.androidrecipes.meals.core.coroutines.DispatcherProvider
import br.com.lucasIsrael.androidrecipes.meals.core.model.ClientResult
import kotlinx.coroutines.withContext
import java.net.ConnectException
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val categoryDataSource: CategoryDataSource) :
    CategoryRepository {

    override suspend fun getCategory(category: String): Meals {
        lateinit var payload: Meals

        withContext(DispatcherProvider.IO) {

            val response = categoryDataSource.getCategory(category)

            if (response is ClientResult.ClientSuccess) {
                payload = response.data
            }

            if (response is ClientResult.ClientError) {
                throw ConnectException(response.errorMessage)
            }
        }

        return payload
    }
}