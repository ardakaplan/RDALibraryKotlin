package com.ardakaplan.rdalibrary.helpers.extensions

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Created by Arda Kaplan at 12.04.2022 - 11:19
 *
 * ardakaplan101@gmail.com
 */
inline fun <T : Fragment> T.withArgs(argsBuilder: Bundle.() -> Unit): T =
    this.apply {
        arguments = Bundle().apply(argsBuilder)
    }