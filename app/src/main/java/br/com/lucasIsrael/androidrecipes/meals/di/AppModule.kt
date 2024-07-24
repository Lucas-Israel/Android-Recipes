package br.com.lucasIsrael.androidrecipes.meals.di

import br.com.lucasIsrael.androidrecipes.meals.config.Configs.BASE_URL
import br.com.lucasIsrael.androidrecipes.meals.data.api.ApiService
import br.com.lucasIsrael.androidrecipes.meals.data.network.CategoriesDataSource
import br.com.lucasIsrael.androidrecipes.meals.data.network.CategoriesDataSourceImpl
import br.com.lucasIsrael.androidrecipes.meals.data.repository.CategoriesRepository
import br.com.lucasIsrael.androidrecipes.meals.data.repository.CategoriesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService() : ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoriesDataSource(api: ApiService) : CategoriesDataSource {
        return CategoriesDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideCategoriesRepository(dataSource: CategoriesDataSource) : CategoriesRepository {
        return CategoriesRepositoryImpl(dataSource)
    }
}
