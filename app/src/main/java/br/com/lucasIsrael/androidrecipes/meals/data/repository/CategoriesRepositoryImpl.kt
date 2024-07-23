package br.com.lucasIsrael.androidrecipes.meals.data.repository

import br.com.lucasIsrael.androidrecipes.meals.data.coroutines.DispatcherProvider
import br.com.lucasIsrael.androidrecipes.meals.data.model.Categories
import br.com.lucasIsrael.androidrecipes.meals.data.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.data.network.CategoriesDataSource
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