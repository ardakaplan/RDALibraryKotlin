package com.ardakaplan.rdalibrary.helpers.extensions

import android.content.Intent
import android.os.Build
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by Arda Kaplan at 13.10.2022 - 12:48
 *
 * ardakaplan101@gmail.com
 */
inline fun <reified T : Parcelable> Intent.getParcelableData(key : String) : T? = when {

    Build.VERSION.SDK_INT >= 33 -> {

        getParcelableExtra(key, T::class.java)
    }

    else -> {

        @Suppress("DEPRECATION") getParcelableExtra(key) as? T
    }
}

inline fun <reified T : Serializable> Intent.getSerializableData(key : String) : T? = when {

    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> {

        getSerializableExtra(key, T::class.java)
    }

    else -> {

        @Suppress("DEPRECATION") getSerializableExtra(key) as? T
    }
}