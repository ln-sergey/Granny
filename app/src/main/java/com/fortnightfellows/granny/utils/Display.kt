package com.fortnightfellows.granny.utils

import android.content.Context

object Display {

    fun pxFromDp(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}