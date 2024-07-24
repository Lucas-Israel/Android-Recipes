package br.com.lucasIsrael.androidrecipes.meals.categories.data.repository

import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories
import br.com.lucasIsrael.androidrecipes.meals.core.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.categories.data.network.CategoriesDataSource
import br.com.lucasIsrael.androidrecipes.meals.core.coroutines.DispatcherProvider
import kotlinx.coroutines.withContext
import java.net.ConnectException
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(private val dataSource: CategoriesDataSource) :
    CategoriesRepository {

    override suspend fun getCategories(): Categories {
        lateinit var payload: Categories

        withContext(DispatcherProvider.IO) {

            val response = dataSource.getCategories()

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