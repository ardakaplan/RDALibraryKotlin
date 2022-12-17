package com.ardakaplan.rdalibrary.ui.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

/**
 * Created by Arda Kaplan at 7.04.2022 - 23:50
 *
 * ardakaplan101@gmail.com
 */
open class RDATabItem(
    @StringRes val titleId: Int?,
    @DrawableRes val iconId: Int?,
    val fragment: Fragment? = null
)