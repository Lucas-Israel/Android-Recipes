package br.com.lucasIsrael.androidrecipes.meals.recipe.di

import br.com.lucasIsrael.androidrecipes.BuildConfig.MEAL_URL
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.api.RecipeApiService
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.network.RecipeDataSource
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.network.RecipeDataSourceImpl
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.repository.RecipeRepository
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RecipeModule {

    @Provides
    @Singleton
    fun provideRecipeApiService(): RecipeApiService {
        return Retrofit.Builder()
            .baseUrl(MEAL_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeDataSource(api: RecipeApiService): RecipeDataSource {
        return RecipeDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(dataSource: RecipeDataSource): RecipeRepository {
        return RecipeRepositoryImpl(dataSource)
    }
}
