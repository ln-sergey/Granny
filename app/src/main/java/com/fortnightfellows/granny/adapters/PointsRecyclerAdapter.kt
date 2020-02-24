package com.fortnightfellows.granny.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.api_wrapper.models.Point
import com.fortnightfellows.granny.databinding.PointsItemBinding

class PointsRecyclerAdapter(
    private var context: Context,
    private var listItems: List<Point>
): RecyclerView.Adapter<PointsRecyclerAdapter.RecyclerHolder>() {

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder =
        RecyclerHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.points_item,
            parent,
            false
        ))

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.binding.point = listItems[position]
    }

    class RecyclerHolder(val binding: PointsItemBinding): RecyclerView.ViewHolder(binding.root)
}