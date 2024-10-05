package com.example.myrecipe_kotlin_mvvm_json

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Error

class MainViewModel: ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())

    // this State Key word will help us update the data in UI once changed
    val categoriesState : State<RecipeState> = _categoriesState

    init {
        // this will start the function to fetch API
        fetchCategories()
    }


    // to call the api to fetch data and store in _categoriesState
    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                // Call api and store data
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            } catch (e: Exception) {

                // using copy we are just changing the value of two variable
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error Fetching Categories ${e.message}"
                )
            }
        }
    }

    // used to handle UI loading, error and fetching updates
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null          // if error than display. If mo error than ? make it null
    )

}