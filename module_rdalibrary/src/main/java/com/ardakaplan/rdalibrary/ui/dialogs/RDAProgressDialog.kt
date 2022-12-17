package com.ardakaplan.rdalibrary.ui.dialogs

import android.app.Activity
import android.view.ViewGroup
import com.ardakaplan.rdalibrary.BuildConfig
import com.ardakaplan.rdalibrary.R


/**
 * Created by Arda Kaplan at 23.02.2022 - 13:58
 *
 * ardakaplan101@gmail.com
 */
abstract class RDAProgressDialog(
    activity: Activity
) : RDADialog(activity, R.style.Theme_Dialog_min_max_width_50) {

    init {

        if (!BuildConfig.DEBUG) {

            this.setCancelable(false)
        }

        this.setCanceledOnTouchOutside(false)

        window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}