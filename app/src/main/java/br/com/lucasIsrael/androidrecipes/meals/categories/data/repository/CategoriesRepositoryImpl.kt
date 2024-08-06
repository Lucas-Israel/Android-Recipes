package br.com.lucasIsrael.androidrecipes.meals.categories.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.categories.data.network.CategoriesDataSource
import br.com.lucasIsrael.androidrecipes.common.coroutines.safeApiCall
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(private val dataSource: CategoriesDataSource) :
    CategoriesRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCategories(): ClientResult<Categories> {
        return safeApiCall {
            dataSource.getCategories()
        }
    }
}
