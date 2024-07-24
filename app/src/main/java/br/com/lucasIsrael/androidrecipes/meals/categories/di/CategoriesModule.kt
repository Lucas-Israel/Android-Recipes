package br.com.lucasIsrael.androidrecipes.meals.categories.di

import br.com.lucasIsrael.androidrecipes.meals.core.config.Configs.BASE_URL
import br.com.lucasIsrael.androidrecipes.meals.categories.data.api.CategoriesApiService
import br.com.lucasIsrael.androidrecipes.meals.categories.data.network.CategoriesDataSource
import br.com.lucasIsrael.androidrecipes.meals.categories.data.network.CategoriesDataSourceImpl
import br.com.lucasIsrael.androidrecipes.meals.categories.data.repository.CategoriesRepository
import br.com.lucasIsrael.androidrecipes.meals.categories.data.repository.CategoriesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoriesModule {

    @Provides
    @Singleton
    fun provideApiService() : CategoriesApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoriesApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoriesDataSource(api: CategoriesApiService) : CategoriesDataSource {
        return CategoriesDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideCategoriesRepository(dataSource: CategoriesDataSource) : CategoriesRepository {
        return CategoriesRepositoryImpl(dataSource)
    }
}
