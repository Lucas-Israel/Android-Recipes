package br.com.lucasIsrael.androidrecipes.meals.recipe.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals
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

    private val _meals = MutableLiveData<Meals>()
    val meals: MutableLiveData<Meals>
        get() = _meals

    private val _fetchError = MutableStateFlow<Boolean>(false)
    val fetchError: StateFlow<Boolean>
        get() = _fetchError

    fun getRecipe(id: String) {
        viewModelScope.launch {
            try {
                val response = recipeRepository.getRecipe(id)
                _meals.postValue(response)
                _fetchError.value = false
            } catch (e: ConnectException) {
                _fetchError.value = true
            }
        }
    }

}