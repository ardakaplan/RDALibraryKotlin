package com.ardakaplan.rdalibrary.helpers.extensions

import android.view.animation.Animation

/**
 * Created by Arda Kaplan at 27.04.2022 - 03:05
 *
 * ardakaplan101@gmail.com
 */

fun Animation.doAfter(doAfter: () -> Unit) {

    setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {}
        override fun onAnimationRepeat(animation: Animation) {}
        override fun onAnimationEnd(animation: Animation) {

            doAfter()
        }
    })
}