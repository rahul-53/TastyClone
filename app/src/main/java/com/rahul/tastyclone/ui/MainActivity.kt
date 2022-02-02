package com.rahul.tastyclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rahul.tastyclone.R
import com.rahul.tastyclone.model.api.APIResponse
import com.rahul.tastyclone.model.api.RetrofitInstance
import com.rahul.tastyclone.repository.RecipeRepository
import com.rahul.tastyclone.viewmodel.RecipeViewModel
import com.rahul.tastyclone.viewmodel.RecipeViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recipeViewModel: RecipeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBottomNavigationBar()

        val apiService = RetrofitInstance.getInstance().create(APIResponse::class.java)

        val recipeRepository = RecipeRepository(apiService)
        recipeViewModel=
            ViewModelProvider(this,
                RecipeViewModelFactory(recipeRepository))
                .get(RecipeViewModel::class.java)
    }

    //bottom navigation bar
    private fun setBottomNavigationBar(){
        val  navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.discoverFragment,R.id.myBagFragment, R.id.myRecipeFragment))

        setupActionBarWithNavController(navController,appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
    }

}