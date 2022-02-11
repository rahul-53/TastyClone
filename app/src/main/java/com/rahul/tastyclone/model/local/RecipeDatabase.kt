package com.rahul.tastyclone.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rahul.tastyclone.model.remote.ExtendedIngredient

@Database(entities = [ExtendedIngredient::class], version = 1)
abstract class RecipeDatabase:RoomDatabase() {
    abstract fun recipeDao():RecipeDAO

    companion object{
        @Volatile
        private var INSTANCE:RecipeDatabase? = null
        fun getDatabase(context: Context):RecipeDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        RecipeDatabase::class.java,
                        "recipeDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

}