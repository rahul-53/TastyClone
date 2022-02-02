package com.rahul.tastyclone.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rahul.tastyclone.model.remote.ExtendedIngredient

@Dao
interface RecipeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(extendedIngredient: ExtendedIngredient)

    @Query("SELECT * FROM recipe_db")
    fun getRecipe():LiveData<List<ExtendedIngredient>>

    @Delete
    suspend fun deleteRecipe(extendedIngredient: ExtendedIngredient)
}