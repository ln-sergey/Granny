package com.fortnightfellows.granny.views

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import android.view.ViewOutlineProvider
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.ui.activities.MainActivity
import com.fortnightfellows.granny.ui.fragments.RecipeFragment
import com.fortnightfellows.granny.animations.CustomBounceInterpolator
import com.fortnightfellows.granny.utils.ImagePreviewerUtils
import com.fortnightfellows.granny.utils.Vibrations.vibrate


class HintedImageButton : androidx.appcompat.widget.AppCompatImageView, View.OnDragListener {

    var screen: View? = null

    @RequiresApi(Build.VERSION_CODES.N)
    constructor(context: Context?) : super(context) {
        setOnLongClickListener {
            openPopup(context!!, screen!!.findViewById(R.id.blurBack), this)
            return@setOnLongClickListener true
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setOnLongClickListener {
            openPopup(context!!,
                screen!!.findViewById(R.id.blurBack),
                this)
            return@setOnLongClickListener true
        }
    }

    override fun onDrag(v: View, event: DragEvent): Boolean {
        val normalShape =
            if (v.tag == "popupLike") resources.getDrawable(R.drawable.ic_heart_default, null)
            else resources.getDrawable(R.drawable.btn_cook_default, null)
        val enterShape =
            if (v.tag == "popupLike") resources.getDrawable(R.drawable.ic_heart)
            else resources.getDrawable(R.drawable.btn_cook, null)

        when (event.action) {

            DragEvent.ACTION_DRAG_ENTERED -> {
                vibrate(context)
                v.background = enterShape
            }
            DragEvent.ACTION_DRAG_EXITED -> v.background = normalShape

            DragEvent.ACTION_DROP -> {
                v.background = normalShape
                closePopup(context, screen!!.findViewById(R.id.blurBack))
                if (v.tag == "popupLike") like()
                else openRecipe()
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                v.background = normalShape
                closePopup(context, screen!!.findViewById(R.id.blurBack))
            }
        }
        return true
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun openPopup(context: Context, popupLayout: FrameLayout, onDragListener: OnDragListener) {
        vibrate(context)
        screen!!.findViewById<FrameLayout>(R.id.frameLayout).outlineProvider = null
        popupLayout.background = ImagePreviewerUtils
            .getBlurredScreenDrawable(context, screen)
        val blurBackAnimator = ObjectAnimator.ofFloat(popupLayout, "alpha", 0.0f, 1.0f)
        blurBackAnimator.duration = 150
        with(popupLayout.findViewById<ConstraintLayout>(R.id.window)) {
            alpha = 0.0f
            findViewById<View>(R.id.popupLike).setOnDragListener(onDragListener)
            findViewById<View>(R.id.popupStart).setOnDragListener(onDragListener)
            val animator = AnimatorInflater.loadAnimator(
                context,
                R.animator.popup_in
            ).apply {
                setTarget(this@with)
                interpolator =
                    CustomBounceInterpolator()
            }
            popupLayout.visibility = View.VISIBLE
            visibility = View.VISIBLE
            popupLayout.bringToFront()
            blurBackAnimator.start()
            animator.start()

            // Start drag and drop after 10 mills
            Handler().postDelayed({
                val temp = findViewById<TextView>(R.id.hidden)
                val shadowBuilder = DragShadowBuilder(temp)
                temp.startDragAndDrop(null, shadowBuilder, temp, 0)
            }, 10)
        }
    }

    private fun closePopup(context: Context, popupLayout: FrameLayout) {
        val blurBackAnimator = ObjectAnimator.ofFloat(popupLayout, "alpha", 1.0f, 0.0f)
        blurBackAnimator.duration = 150
        with(popupLayout.findViewById<ConstraintLayout>(R.id.window)) {
            val animator = AnimatorInflater.loadAnimator(
                context,
                R.animator.popup_out
            ).apply {
                setTarget(this@with)
                interpolator = LinearInterpolator()
            }
            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {}
                override fun onAnimationRepeat(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {
                    popupLayout.visibility = GONE
                    visibility = GONE
                    alpha = 1.0f
                }

                override fun onAnimationCancel(animation: Animator?) {
                    popupLayout.visibility = GONE
                    visibility = GONE
                    alpha = 1.0f
                }

            })
            animator.start()
            blurBackAnimator.start()
        }
    }

    private fun like() {}

    private fun openRecipe() {
        (context as MainActivity).openFragment(RecipeFragment())
    }
}