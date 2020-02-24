package com.fortnightfellows.granny.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.adapters.FeedRecyclerAdapter
import com.fortnightfellows.granny.api_wrapper.models.FeedItem
import com.fortnightfellows.granny.databinding.FeedFragmentBinding
import com.fortnightfellows.granny.view_models.FeedFragmentViewModel

class FeedFragment : Fragment() {

    private lateinit var binding: FeedFragmentBinding
    private lateinit var viewModel: FeedFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.feed_fragment, container, false)
        viewModel = FeedFragmentViewModel()
        binding.model = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(context!!)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter =
            FeedRecyclerAdapter(activity!!.findViewById<View>(R.id.mainLayout), context!!, listOf(FeedItem(), FeedItem(), FeedItem(), FeedItem(), FeedItem()))
    }

}
