package br.com.lucasIsrael.androidrecipes.meals.recipe.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Recipe
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {

    private val _recipe = MutableStateFlow<Recipe?>(null)
    val recipe: MutableStateFlow<Recipe?>
        get() = _recipe

    private val _fetchError = MutableStateFlow(false)
    val fetchError: StateFlow<Boolean>
        get() = _fetchError

    fun getRecipe(id: String) {
        viewModelScope.launch {
            try {
                when (val response = recipeRepository.getRecipe(id)) {
                    is ClientResult.ClientSuccess -> {
                        _recipe.value = response.data.meals[0]
                        _fetchError.value = false
                    }

                    is ClientResult.ClientError -> {
                        _fetchError.value = true
                    }
                }
            } catch (e: CancellationException) {
                Log.e(e.stackTrace.toString(), e.message.toString())
                _fetchError.value = true
            }
        }
    }

}
