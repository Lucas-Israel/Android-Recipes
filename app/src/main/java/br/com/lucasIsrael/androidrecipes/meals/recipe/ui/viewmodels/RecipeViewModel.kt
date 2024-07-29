package br.com.lucasIsrael.androidrecipes.meals.recipe.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Recipe
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {

    private val _fetchError = MutableStateFlow(false)
    val fetchError: StateFlow<Boolean>
        get() = _fetchError

    private val _recipe = MutableLiveData<Recipe>()
    val recipe: MutableLiveData<Recipe>
        get() = _recipe

    fun getRecipe(id: String) {
        viewModelScope.launch {
            try {
                val response = recipeRepository.getRecipe(id)
                val recipe = response.meals[0]
                _fetchError.value = false
                _recipe.postValue(recipe)
            } catch (e: ConnectException) {
                _fetchError.value = true
            }
        }
    }

}
