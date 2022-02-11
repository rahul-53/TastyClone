package com.rahul.tastyclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.tastyclone.R
import com.rahul.tastyclone.model.remote.ExtendedIngredient
import kotlinx.android.synthetic.main.item_layout.view.*

class RecipeAdapter:RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    private val diffCallback =object :DiffUtil.ItemCallback<ExtendedIngredient>(){
        override fun areItemsTheSame(
            oldItem: ExtendedIngredient,
            newItem: ExtendedIngredient
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ExtendedIngredient,
            newItem: ExtendedIngredient
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe =differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(recipe.image).into(recipeImg)
            recipeName.text = recipe.name
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}