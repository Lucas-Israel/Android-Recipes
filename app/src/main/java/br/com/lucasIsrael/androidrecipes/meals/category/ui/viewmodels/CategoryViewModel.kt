package br.com.lucasIsrael.androidrecipes.meals.category.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.category.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) :
    ViewModel() {

    private val _meals = MutableStateFlow<Meals>(Meals(listOf()))
    val meals: MutableStateFlow<Meals>
        get() = _meals

    private val _fetchError = MutableStateFlow(false)
    val fetchError: StateFlow<Boolean>
        get() = _fetchError

    fun getCategory(category: String) {
        viewModelScope.launch {
            try {
                when (val response = repository.getCategory(category)) {
                    is ClientResult.ClientSuccess -> {
                        _meals.value = response.data
                        _fetchError.value = false
                    }

                    is ClientResult.ClientError -> {
                        _fetchError.value = true
                    }
                }
            } catch (e: CancellationException) {
                e.printStackTrace()
                _fetchError.value = true
            }
        }
    }

}
