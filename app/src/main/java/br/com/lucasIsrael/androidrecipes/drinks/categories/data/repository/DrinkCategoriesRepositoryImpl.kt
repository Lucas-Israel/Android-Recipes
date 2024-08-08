package br.com.lucasIsrael.androidrecipes.drinks.categories.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasIsrael.androidrecipes.common.coroutines.safeApiCall
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.model.DrinkCategories
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.network.DrinkCategoriesDataSource
import javax.inject.Inject

class DrinkCategoriesRepositoryImpl @Inject constructor(private val dataSource: DrinkCategoriesDataSource) :
    DrinkCategoriesRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCategories(): ClientResult<DrinkCategories> {
        return safeApiCall {
            dataSource.getCategories()
        }
    }
}
