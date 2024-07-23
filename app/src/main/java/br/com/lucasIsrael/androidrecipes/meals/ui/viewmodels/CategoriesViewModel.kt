package br.com.lucasIsrael.androidrecipes.meals.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.meals.data.model.Categories
import br.com.lucasIsrael.androidrecipes.meals.data.repository.CategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val repository: CategoriesRepository) :
    ViewModel() {

        private val _categories = MutableLiveData<Categories>()
        val categories: MutableLiveData<Categories>
            get() = _categories

        private val _fetchError = MutableStateFlow(false)
        val fetchError: StateFlow<Boolean>
            get() = _fetchError

        fun getCategories() {
            viewModelScope.launch {
                try {
                    val response = repository.getCategories()
                    _categories.postValue(response)
                } catch (e: ConnectException) {
                    _fetchError.value = true
                }
            }
        }
}