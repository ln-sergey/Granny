package com.fortnightfellows.granny.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.adapters.RecyclerAdapter
import com.fortnightfellows.granny.api_wrapper.models.FeedItem
import com.fortnightfellows.granny.databinding.ActivityMainBinding
import com.fortnightfellows.granny.view_models.EnterActivityViewModel
import com.fortnightfellows.granny.view_models.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainActivityViewModel()
        binding.model = viewModel
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter =
            RecyclerAdapter(this, listOf(FeedItem(), FeedItem(), FeedItem(), FeedItem(), FeedItem()))
    }
}
