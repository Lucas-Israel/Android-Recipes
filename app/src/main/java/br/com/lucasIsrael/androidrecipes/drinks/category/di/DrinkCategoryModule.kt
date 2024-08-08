package br.com.lucasIsrael.androidrecipes.drinks.category.di

import br.com.lucasIsrael.androidrecipes.BuildConfig.DRINK_URL
import br.com.lucasIsrael.androidrecipes.drinks.category.data.api.DrinkCategoryApiService
import br.com.lucasIsrael.androidrecipes.drinks.category.data.network.DrinkCategoryDataSource
import br.com.lucasIsrael.androidrecipes.drinks.category.data.network.DrinkCategoryDataSourceImpl
import br.com.lucasIsrael.androidrecipes.drinks.category.data.repository.DrinkCategoryRepository
import br.com.lucasIsrael.androidrecipes.drinks.category.data.repository.DrinkCategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrinkCategoryModule {

    @Provides
    @Singleton
    fun provideDrinkCategoryApiService(): DrinkCategoryApiService {
        return Retrofit.Builder()
            .baseUrl(DRINK_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DrinkCategoryApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDrinkCategoryDataSource(apiService: DrinkCategoryApiService): DrinkCategoryDataSource {
        return DrinkCategoryDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideDrinkCategoryRepository(dataSource: DrinkCategoryDataSource): DrinkCategoryRepository {
        return DrinkCategoryRepositoryImpl(dataSource)
    }
}
