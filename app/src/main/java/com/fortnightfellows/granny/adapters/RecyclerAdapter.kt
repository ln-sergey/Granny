package com.fortnightfellows.granny.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.api_wrapper.models.FeedItem
import com.fortnightfellows.granny.databinding.FeedItemBinding

class RecyclerAdapter(
    private var context: Context,
    private var listItems: List<FeedItem>
): RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>() {

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
        if (position == 0) {
            val params = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(16, 300, 16, 16)
            holder.binding.contentWrapper.layoutParams = params
        }
    }

    class RecyclerHolder(val binding: FeedItemBinding): RecyclerView.ViewHolder(binding.root)
}