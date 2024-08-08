package br.com.lucasIsrael.androidrecipes.drinks.category.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasIsrael.androidrecipes.common.model.ClientResult
import br.com.lucasIsrael.androidrecipes.drinks.category.data.model.DrinksCategory
import br.com.lucasIsrael.androidrecipes.drinks.category.data.repository.DrinkCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class DrinkCategoryViewModel @Inject constructor(private val repository: DrinkCategoryRepository) :
    ViewModel() {

    private val _drinkCategory = MutableStateFlow<DrinksCategory>(DrinksCategory(listOf()))
    val drinkCategory: MutableStateFlow<DrinksCategory>
        get() = _drinkCategory

    private val _fetchError = MutableStateFlow<Boolean>(false)
    val fetchError: MutableStateFlow<Boolean>
        get() = _fetchError

    fun getCategory(drinkCategory: String) {
        val drinkNoSpace = drinkCategory.replace(" ", "_")

        viewModelScope.launch {
            try {
                when (val response = repository.getCategory(drinkNoSpace)) {
                    is ClientResult.ClientSuccess -> {
                        _drinkCategory.value = response.data
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
