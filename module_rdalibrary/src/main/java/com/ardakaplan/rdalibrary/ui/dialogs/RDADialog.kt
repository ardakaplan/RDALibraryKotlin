package com.ardakaplan.rdalibrary.ui.dialogs

import android.app.Activity
import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes


/**
 * Created by Arda Kaplan at 24.01.2022 - 11:31
 *
 * ardakaplan101@gmail.com
 */
abstract class RDADialog(
    activity: Activity,
    @StyleRes style: Int
) : Dialog(activity, style) {

    init {

        setOwnerActivity(activity)

        requestWindowFeature(Window.FEATURE_NO_TITLE)

        this.setContentView(getLayoutId())

        window?.setBackgroundDrawableResource(android.R.color.transparent)

//        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
}