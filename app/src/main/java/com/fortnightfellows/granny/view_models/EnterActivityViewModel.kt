package com.fortnightfellows.granny.view_models

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.fortnightfellows.granny.ui.activities.EnterActivity
import com.fortnightfellows.granny.ui.activities.MainActivity
import java.lang.ref.WeakReference

class EnterActivityViewModel(
    private val context: WeakReference<EnterActivity>
): ViewModel() {

    fun enter() {
        context.get()?.startActivity(Intent(context.get(), MainActivity::class.java))
    }
}