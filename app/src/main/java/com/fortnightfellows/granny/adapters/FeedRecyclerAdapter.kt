package com.fortnightfellows.granny.adapters

import android.content.Context
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.api_wrapper.models.FeedItem
import com.fortnightfellows.granny.databinding.FeedItemBinding

class FeedRecyclerAdapter(
    val screen: View,
    private var context: Context,
    private var listItems: List<FeedItem>
): RecyclerView.Adapter<FeedRecyclerAdapter.RecyclerHolder>() {

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder =
        RecyclerHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.feed_item,
            parent,
            false
        ))

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.binding.image.screen = screen
        holder.binding.model = listItems[position]
    }

    class RecyclerHolder(val binding: FeedItemBinding): RecyclerView.ViewHolder(binding.root)
}