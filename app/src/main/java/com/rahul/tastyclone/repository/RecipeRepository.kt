package com.rahul.tastyclone.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rahul.tastyclone.model.api.APIResponse
import com.rahul.tastyclone.model.remote.ExtendedIngredient
import com.rahul.tastyclone.model.remote.RecipeResponse

class RecipeRepository(private val apiResponse: APIResponse) {

    private val recipeLiveData = MutableLiveData<RecipeResponse>()
    val recipeData : LiveData<RecipeResponse>
    get()= recipeLiveData
    suspend fun getRecipe(){
        val recipes = apiResponse.getRecipe()
        if(recipes?.body() !=null){
            recipeLiveData.postValue(recipes.body())
        }
    }

}