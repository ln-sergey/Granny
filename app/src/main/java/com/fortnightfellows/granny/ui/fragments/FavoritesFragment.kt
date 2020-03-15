package com.fortnightfellows.granny.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.adapters.FavoritesRecyclerAdapter
import com.fortnightfellows.granny.api_wrapper.models.FeedItem
import com.fortnightfellows.granny.databinding.FavoritesFragmentBinding
import com.fortnightfellows.granny.view_models.FavoritesFragmentViewModel

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
        binding.recyclerView.adapter =
            FavoritesRecyclerAdapter(activity!!.findViewById<View>(R.id.mainLayout), this.context!!, listOf(FeedItem(), FeedItem(), FeedItem(), FeedItem(), FeedItem()))
        return binding.root
    }

}
