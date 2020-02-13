package com.fortnightfellows.granny.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.databinding.ActivityEnterBinding
import com.fortnightfellows.granny.view_models.EnterActivityViewModel
import java.lang.ref.WeakReference

class EnterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnterBinding
    private lateinit var viewModel: EnterActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_enter)
        viewModel = EnterActivityViewModel(WeakReference(this))
        binding.model = viewModel
    }
}
