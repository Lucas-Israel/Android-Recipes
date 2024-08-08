package br.com.lucasIsrael.androidrecipes.drinks.categories.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.model.DrinkCategories
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.repository.DrinkCategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class DrinkCategoriesViewModel @Inject constructor(private val repository: DrinkCategoriesRepository) :
    ViewModel() {

        private val _drinkCategories = MutableStateFlow<DrinkCategories>(DrinkCategories(listOf()))
        val drinkCategories: MutableStateFlow<DrinkCategories>
            get() = _drinkCategories

        private val _fetchError = MutableStateFlow<Boolean>(false)
        val fetchError: MutableStateFlow<Boolean>
            get() = _fetchError

        fun getCategories() {
            viewModelScope.launch {
                try {
                    when (val response = repository.getCategories()) {
                        is ClientResult.ClientSuccess -> {
                            _drinkCategories.value = response.data
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
