package com.fortnightfellows.granny.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.api_wrapper.models.FeedItem
import com.fortnightfellows.granny.api_wrapper.models.Ingredient
import com.fortnightfellows.granny.databinding.FeedItemBinding
import com.fortnightfellows.granny.databinding.IngredientsItemBinding

class IngredientsRecyclerAdapter(
    private var context: Context,
    private var listItems: List<Ingredient>
): RecyclerView.Adapter<IngredientsRecyclerAdapter.RecyclerHolder>() {

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder =
        RecyclerHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.ingredients_item,
            parent,
            false
        ))

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.binding.ingredient = listItems[position]
    }

    class RecyclerHolder(val binding: IngredientsItemBinding): RecyclerView.ViewHolder(binding.root)
}