package br.com.lucasIsrael.androidrecipes.meals.categories.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Categories
import br.com.lucasIsrael.androidrecipes.meals.categories.data.repository.CategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val repository: CategoriesRepository) :
    ViewModel() {

    private val _categories = MutableStateFlow<Categories>(Categories(listOf()))
    val categories: MutableStateFlow<Categories>
        get() = _categories

    private val _fetchError = MutableStateFlow(false)
    val fetchError: StateFlow<Boolean>
        get() = _fetchError

    fun getCategories() {
        viewModelScope.launch {
            try {
                when (val response = repository.getCategories()) {
                    is ClientResult.ClientSuccess -> {
                        _categories.value = response.data
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
