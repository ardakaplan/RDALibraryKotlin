package com.ardakaplan.rdalibrary.helpers

import android.R
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Arda Kaplan at 7.04.2022 - 12:11
 *
 * ardakaplan101@gmail.com
 */
@Singleton
class RDAScreenHelpers @Inject constructor(@ApplicationContext var context: Context) {

    companion object {

        fun closeKeyboard(activity: AppCompatActivity?) {

            activity?.let {

                val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

                inputMethodManager.hideSoftInputFromWindow(activity.window.decorView.windowToken, 0)
            }
        }

        fun showKeyboard(context: Context?, editText: EditText) {

            val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        }

        fun setKeyboardVisibilityListener(activity: Activity, keyboardVisibilityListener: KeyboardVisibilityListener) {

            val contentView: View = activity.findViewById(R.id.content)

            contentView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {

                private var mPreviousHeight = 0

                override fun onGlobalLayout() {

                    val newHeight: Int = contentView.height
                    if (mPreviousHeight != 0) {

                        when {
                            mPreviousHeight > newHeight -> {
                                // Height decreased: keyboard was shown
                                keyboardVisibilityListener.onKeyboardVisibilityChanged(true)
                            }
                            mPreviousHeight < newHeight -> {
                                // Height increased: keyboard was hidden
                                keyboardVisibilityListener.onKeyboardVisibilityChanged(false)
                            }
                            else -> {
                                // No change
                            }
                        }
                    }
                    mPreviousHeight = newHeight
                }
            })
        }
    }

    interface KeyboardVisibilityListener {

        fun onKeyboardVisibilityChanged(keyboardVisibility: Boolean)
    }
}