package com.example.helpfindrecipes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.helpfindrecipes.R
import com.example.helpfindrecipes.databinding.ListItemBinding
import com.example.recipes.retrofit.Recipe

class RecipeAdapter : ListAdapter<Recipe, RecipeAdapter.Holder>(Comparator()){


    class Holder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ListItemBinding.bind(view)

        fun bind(recipe: Recipe)= with(binding){
            title.text = recipe.name
            description.text = recipe.rating.toString()
        }
    }
    class Comparator : DiffUtil.ItemCallback<Recipe>(){
        override fun areItemsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean {
        return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(
        holder: Holder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}