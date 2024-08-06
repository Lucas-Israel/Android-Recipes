package br.com.lucasIsrael.androidrecipes.drinks.categories.di

import br.com.lucasIsrael.androidrecipes.BuildConfig.DRINK_URL
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.api.DrinkCategoriesApiService
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.network.DrinkCategoriesDataSource
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.network.DrinkCategoriesDataSourceImpl
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.repository.DrinkCategoriesRepository
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.repository.DrinkCategoriesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrinkCategoriesModule {

    @Provides
    @Singleton
    fun provideDrinkCategoriesApiService(): DrinkCategoriesApiService {
        return Retrofit.Builder()
            .baseUrl(DRINK_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DrinkCategoriesApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDrinkCategoriesDataSource(apiService: DrinkCategoriesApiService): DrinkCategoriesDataSource {
        return DrinkCategoriesDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideDrinkCategoriesRepository(datasource: DrinkCategoriesDataSource): DrinkCategoriesRepository {
        return DrinkCategoriesRepositoryImpl(datasource)
    }
}
