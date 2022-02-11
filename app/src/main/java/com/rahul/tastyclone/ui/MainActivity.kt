package com.rahul.tastyclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.tastyclone.R
import com.rahul.tastyclone.RecipeApp
import com.rahul.tastyclone.adapter.RecipeAdapter
import com.rahul.tastyclone.model.api.APIResponse
import com.rahul.tastyclone.model.api.RetrofitInstance
import com.rahul.tastyclone.repository.RecipeRepository
import com.rahul.tastyclone.util.Resource
import com.rahul.tastyclone.viewmodel.RecipeViewModel
import com.rahul.tastyclone.viewmodel.RecipeViewModelFactory


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*

class MainActivity : AppCompatActivity() {

    lateinit var recipeViewModel: RecipeViewModel
    lateinit var recipeAdapter:RecipeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as RecipeApp).recipeRepository
        recipeViewModel=
            ViewModelProvider(this,
                RecipeViewModelFactory(repository))
                .get(RecipeViewModel::class.java)
        setRecyclerView()

        recipeViewModel.recipe.observe(this, Observer {
         Log.d("tag", it.instructions.toString())

        })
    }

    private fun setRecyclerView(){
        recipeAdapter = RecipeAdapter()
        rvDiscover.apply {
            adapter = recipeAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }

}