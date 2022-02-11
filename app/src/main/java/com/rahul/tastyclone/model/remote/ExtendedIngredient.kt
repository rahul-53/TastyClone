package com.rahul.tastyclone.model.remote

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipe_db")
data class ExtendedIngredient(

    @PrimaryKey(autoGenerate = true)
    val recipe_id:Int,
    val aisle: String,
    val amount: Double,
    val consistency: String,
    val id: Int,
    val image: String,
    val measures: Measures,
    val meta: List<String>,
    val name: String,
    val nameClean: String,
    val original: String,
    val originalName: String,
    val unit: String
)