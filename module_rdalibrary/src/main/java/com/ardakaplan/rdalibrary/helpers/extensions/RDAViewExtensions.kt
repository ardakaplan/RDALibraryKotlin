package com.ardakaplan.rdalibrary.helpers.extensions

import android.graphics.drawable.Drawable
import android.os.SystemClock
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat


/**
 * Created by Arda Kaplan at 18.01.2022 - 21:22
 *
 * ardakaplan101@gmail.com
 */
fun View.showAnimationEndCallback(@AnimRes animRes: Int, doAfter: () -> Unit) {

    val loadAnimation = AnimationUtils.loadAnimation(context, animRes)

    loadAnimation.setAnimationListener(object : Animation.AnimationListener {

        override fun onAnimationStart(animation: Animation?) {}

        override fun onAnimationEnd(animation: Animation?) {

            doAfter()
        }

        override fun onAnimationRepeat(animation: Animation?) {}

    })

    startAnimation(loadAnimation)
}

fun View.showAnimation(@AnimRes animRes: Int) {

    showAnimationEndCallback(animRes) {}
}

@ColorInt
fun View.getColor(@ColorRes colorRes: Int): Int {

    return ContextCompat.getColor(context, colorRes)
}

fun View.getDrawable(@DrawableRes drawableRes: Int): Drawable {

    return ContextCompat.getDrawable(context, drawableRes)!!
}

fun View.adjustVisibilityByBoolean(show: Boolean) {

    if (show) {

        visible()

    } else {

        gone()
    }
}

fun View.gone() {

    visibility = View.GONE
}

fun View.visible() {

    visibility = View.VISIBLE
}

fun View.invisible() {

    visibility = View.INVISIBLE
}

fun View.setOnSingleClickListener(debounceTime: Long = 600L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}
