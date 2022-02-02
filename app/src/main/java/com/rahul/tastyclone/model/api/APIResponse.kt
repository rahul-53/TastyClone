package com.rahul.tastyclone.model.api

import com.rahul.tastyclone.model.remote.RecipeResponse
import com.rahul.tastyclone.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIResponse {
    @GET("recipes/716429/information")
    suspend fun getRecipe(
        @Query("apiKey")
        apiKey:String = API_KEY
    ):Response<RecipeResponse>
}