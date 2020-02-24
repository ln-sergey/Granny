package com.fortnightfellows.granny.ui.activities

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.databinding.ActivityMainBinding
import com.fortnightfellows.granny.ui.fragments.FavoritesFragment
import com.fortnightfellows.granny.ui.fragments.FeedFragment
import com.fortnightfellows.granny.ui.fragments.SearchFragment
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

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
        transaction.replace(R.id.container, fragment)
        if (fragment::class != FeedFragment::class &&
                fragment::class != SearchFragment::class &&
                fragment::class != FavoritesFragment::class)
            transaction.addToBackStack(null)
        transaction.commit()
    }
}
