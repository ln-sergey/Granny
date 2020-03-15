package com.fortnightfellows.granny.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.databinding.SearchFragmentBinding
import com.fortnightfellows.granny.view_models.SearchFragmentViewModel

class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding
    private lateinit var viewModel: SearchFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.search_fragment, container, false)
        viewModel = SearchFragmentViewModel()
        binding.model = viewModel
        return binding.root
    }
}
