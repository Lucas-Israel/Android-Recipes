package br.com.lucasIsrael.androidrecipes.meals.category.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.meals.category.data.model.CategoryMeal
import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.category.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) :
    ViewModel() {

    private val _meals = MutableLiveData<Meals>()
    val meals: MutableLiveData<Meals>
        get() = _meals

    private val _fetchError = MutableStateFlow(false)
    val fetchError: StateFlow<Boolean>
        get() = _fetchError

    fun getCategory(category: String) {
        viewModelScope.launch {
            try {
                val response = repository.getCategory(category)
                _meals.postValue(response)
                _fetchError.value = false
            } catch (e: ConnectException) {
                _fetchError.value = true
            }
        }
    }

}