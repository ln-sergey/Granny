package com.fortnightfellows.granny.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.adapters.RecyclerAdapter
import com.fortnightfellows.granny.api_wrapper.models.FeedItem
import com.fortnightfellows.granny.databinding.ActivityMainBinding
import com.fortnightfellows.granny.ui.fragments.FavoritesFragment
import com.fortnightfellows.granny.ui.fragments.FeedFragment
import com.fortnightfellows.granny.ui.fragments.SearchFragment
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
        openFragment(FeedFragment())
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_feed -> {
                    openFragment(FeedFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_search -> {
                    openFragment(SearchFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_favorites -> {
                    openFragment(FavoritesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
