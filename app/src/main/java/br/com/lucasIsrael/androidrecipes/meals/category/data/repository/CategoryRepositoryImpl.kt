package br.com.lucasIsrael.androidrecipes.meals.category.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.category.data.network.CategoryDataSource
import br.com.lucasIsrael.androidrecipes.common.coroutines.safeApiCall
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val categoryDataSource: CategoryDataSource) :
    CategoryRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCategory(category: String): ClientResult<Meals> {
        return safeApiCall {
            categoryDataSource.getCategory(category)
        }
    }
}
