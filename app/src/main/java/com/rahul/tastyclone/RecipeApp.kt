package com.rahul.tastyclone

import android.app.Application
import com.rahul.tastyclone.model.api.APIResponse
import com.rahul.tastyclone.model.api.RetrofitInstance
import com.rahul.tastyclone.model.local.RecipeDatabase
import com.rahul.tastyclone.repository.RecipeRepository

class RecipeApp:Application() {
    lateinit var recipeRepository: RecipeRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val apiService = RetrofitInstance.getInstance().create(APIResponse::class.java)
        val database = RecipeDatabase.getDatabase(applicationContext)
        recipeRepository = RecipeRepository(apiService, database)
    }
}