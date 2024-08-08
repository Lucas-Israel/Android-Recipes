package br.com.lucasIsrael.androidrecipes.drinks.category.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasIsrael.androidrecipes.common.coroutines.safeApiCall
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.drinks.category.data.model.DrinksCategory
import br.com.lucasIsrael.androidrecipes.drinks.category.data.network.DrinkCategoryDataSource
import javax.inject.Inject

class DrinkCategoryRepositoryImpl @Inject constructor(private val dataSource: DrinkCategoryDataSource) :
    DrinkCategoryRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCategory(drinkCategory: String): ClientResult<DrinksCategory> {
        return safeApiCall {
            dataSource.getCategory(drinkCategory)
        }
    }
}
