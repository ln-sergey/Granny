package com.fortnightfellows.granny.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.adapters.RecyclerAdapter
import com.fortnightfellows.granny.api_wrapper.models.FeedItem
import com.fortnightfellows.granny.databinding.FavoritesFragmentBinding
import com.fortnightfellows.granny.databinding.FeedFragmentBinding
import com.fortnightfellows.granny.view_models.FavoritesFragmentViewModel
import com.fortnightfellows.granny.view_models.FeedFragmentViewModel

class FavoritesFragment : Fragment() {

    private lateinit var binding: FavoritesFragmentBinding
    private lateinit var viewModel: FavoritesFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.favorites_fragment, container, false)
        viewModel = FavoritesFragmentViewModel()
        binding.model = viewModel
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context!!)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter =
            RecyclerAdapter(this.context!!, listOf(FeedItem(), FeedItem(), FeedItem(), FeedItem(), FeedItem()))
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
