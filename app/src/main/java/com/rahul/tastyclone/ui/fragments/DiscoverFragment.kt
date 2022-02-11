package com.rahul.tastyclone.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.tastyclone.R
import com.rahul.tastyclone.adapter.RecipeAdapter
import com.rahul.tastyclone.model.api.APIResponse
import com.rahul.tastyclone.model.api.RetrofitInstance
import com.rahul.tastyclone.repository.RecipeRepository
import com.rahul.tastyclone.ui.MainActivity
import com.rahul.tastyclone.viewmodel.RecipeViewModel
import com.rahul.tastyclone.viewmodel.RecipeViewModelFactory
import kotlinx.android.synthetic.main.fragment_discover.*


class DiscoverFragment : Fragment() {

    /*lateinit var recipeViewModel: RecipeViewModel
    lateinit var recipeAdapter:RecipeAdapter*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setRecyclerView()
        /*val apiService = RetrofitInstance.getInstance().create(APIResponse::class.java)

        val recipeRepository = RecipeRepository(apiService)
        recipeViewModel=
            ViewModelProvider(this,
                RecipeViewModelFactory(recipeRepository)
            )
                .get(RecipeViewModel::class.java)

        recipeViewModel.recipe.observe(viewLifecycleOwner, Observer{
            Log.d("results", it.title.toString())
        })*/


    }

   /* private fun setRecyclerView(){
        recipeAdapter = RecipeAdapter()
        rvDiscover.apply {
            adapter = recipeAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }*/


}