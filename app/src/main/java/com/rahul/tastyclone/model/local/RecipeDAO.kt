package com.rahul.tastyclone.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rahul.tastyclone.model.remote.ExtendedIngredient

@Dao
interface RecipeDAO {
    @Insert
    suspend fun addRecipe(recipes:List<ExtendedIngredient>)

    @Query("SELECT * FROM  recipe_db")
    suspend fun getRecipe():List<ExtendedIngredient>

}