package com.fortnightfellows.granny.views

import android.app.Dialog
import android.content.ClipData
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.AttributeSet
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.OnDragListener
import android.view.View.OnTouchListener
import android.widget.ImageButton
import android.widget.TextView
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.utils.ImagePreviewerUtils


class HintedImageButtonTemp : ImageButton {

    private var dialog: Dialog? = null
    var screen: View? = null

    private val enterShapeLike = resources.getDrawable(R.drawable.ic_heart_default)
    private val normalShapeLike = resources.getDrawable(R.drawable.ic_heart)

    constructor(context: Context?) : super(context) {
        setOnLongClickListener {
            showDialog(it)
            it.setOnTouchListener(listener)
            val hidden = dialog?.findViewById<TextView>(R.id.hidden)
            val data = ClipData.newPlainText("daadada", "addadad")
            val shadowBuilder = DragShadowBuilder(hidden)
            hidden?.startDragAndDrop(data, shadowBuilder, hidden, 0)
            return@setOnLongClickListener true
        }
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setOnLongClickListener {
            showDialog(it)
            it.setOnTouchListener(listener)
            val hidden = dialog?.findViewById<TextView>(R.id.hidden)
            val data = ClipData.newPlainText("daadada", "addadad")
            val shadowBuilder = DragShadowBuilder(hidden)
            hidden?.startDragAndDrop(data, shadowBuilder, hidden, 0)
            return@setOnLongClickListener true
        }
    }

    private val listener = OnTouchListener { v, event ->
        if (dialog!!.isShowing) {
            v.parent.requestDisallowInterceptTouchEvent(true)
            val action = event.actionMasked
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                v.parent.requestDisallowInterceptTouchEvent(false)
                dialog!!.dismiss()
                return@OnTouchListener true
            }
        }
        return@OnTouchListener false
    }

    private val onDrugListenerLike = OnDragListener { v, event ->
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                v.background = enterShapeLike
                vibrate()
            }
            DragEvent.ACTION_DRAG_EXITED -> v.background = normalShapeLike
            DragEvent.ACTION_DROP -> {}
            DragEvent.ACTION_DRAG_ENDED -> v.background = normalShapeLike
            else -> {
            }
        }
        true
    }

    private fun showDialog(source: View) {
        val background: BitmapDrawable =
            ImagePreviewerUtils.getBlurredScreenDrawable(context, screen)

        dialog?.setContentView(R.layout.recipe_preview_dialog)
        dialog?.show()
        dialog?.window?.setBackgroundDrawable(background)
        dialog?.findViewById<ImageButton>(R.id.imageLike)?.setOnDragListener(onDrugListenerLike)
    }

    private fun vibrate() {
        val v =  context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        v.vibrate(VibrationEffect.createOneShot(500, 30))
    }
}