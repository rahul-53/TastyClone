package com.rahul.tastyclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.tastyclone.model.remote.RecipeResponse
import com.rahul.tastyclone.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipeRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getRecipe()
        }
    }
    val recipe: LiveData<RecipeResponse>
    get() = repository.recipeData
}