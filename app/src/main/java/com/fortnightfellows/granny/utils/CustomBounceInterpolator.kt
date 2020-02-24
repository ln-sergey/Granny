package com.fortnightfellows.granny.utils

import android.view.animation.Interpolator
import kotlin.math.cos
import kotlin.math.pow

internal class CustomBounceInterpolator() : Interpolator {
    var mAmplitude = 0.1
    var mFrequency = 6.0

    constructor(amp: Double, freq: Double): this() {
        mAmplitude = amp
        mFrequency = freq
    }

    override fun getInterpolation(time: Float): Float {
        return (-1 * Math.E.pow(-time / mAmplitude) * cos(
            mFrequency * time
        ) + 1).toFloat()
    }
}