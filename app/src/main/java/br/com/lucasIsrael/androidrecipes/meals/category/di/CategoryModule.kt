package br.com.lucasIsrael.androidrecipes.meals.category.di

import br.com.lucasIsrael.androidrecipes.meals.category.data.api.CategoryApiService
import br.com.lucasIsrael.androidrecipes.meals.category.data.network.CategoryDataSource
import br.com.lucasIsrael.androidrecipes.meals.category.data.network.CategoryDataSourceImpl
import br.com.lucasIsrael.androidrecipes.meals.category.data.repository.CategoryRepository
import br.com.lucasIsrael.androidrecipes.meals.category.data.repository.CategoryRepositoryImpl
import br.com.lucasIsrael.androidrecipes.meals.core.config.Configs.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryModule {

    @Provides
    @Singleton
    fun provideCategoryApiService(): CategoryApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryDataSource(api: CategoryApiService): CategoryDataSource {
        return CategoryDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(dataSource: CategoryDataSource): CategoryRepository {
        return CategoryRepositoryImpl(dataSource)
    }
}