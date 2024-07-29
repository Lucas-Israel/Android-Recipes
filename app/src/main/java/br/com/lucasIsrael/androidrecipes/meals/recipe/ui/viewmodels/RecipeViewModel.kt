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

    private val _fetchError = MutableStateFlow(false)
    val fetchError: StateFlow<Boolean>
        get() = _fetchError

    private val _recipeName = MutableLiveData<String>()
    val recipeName: MutableLiveData<String>
        get() = _recipeName

    private val _categoryName = MutableLiveData<String>()
    val categoryName: MutableLiveData<String>
        get() = _categoryName

    private val _recipeArea = MutableLiveData<String>()
    val recipeArea: MutableLiveData<String>
        get() = _recipeArea

    private val _tags = MutableLiveData<String>()
    val tags: MutableLiveData<String>
        get() = _tags

    fun getRecipe(id: String) {
        viewModelScope.launch {
            try {
                val response = recipeRepository.getRecipe(id)
                _fetchError.value = false
                updatingRecipeResponse(response)
            } catch (e: ConnectException) {
                _fetchError.value = true
            }
        }
    }

    private fun updatingRecipeResponse(response: Meals) {
        val recipe = response.meals[0]
        _recipeName.postValue(recipe.strMeal)
        _categoryName.postValue(recipe.strCategory)
        _recipeArea.postValue(recipe.strArea)
        _tags.postValue(recipe.strTags)
    }

}