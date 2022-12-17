package com.ardakaplan.rdalibrary.helpers.extensions

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by Arda Kaplan at 13.10.2022 - 12:48
 *
 * ardakaplan101@gmail.com
 */

inline fun <reified T : Serializable> Bundle.getSerializableData(key: String): T? = when {

    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> {

        getSerializable(key, T::class.java)
    }

    else -> {

        @Suppress("DEPRECATION") getSerializable(key) as? T
    }
}

inline fun <reified T : Parcelable> Bundle.getParcelableData(key: String): T? = when {

    Build.VERSION.SDK_INT >= 33 -> {

        getParcelable(key, T::class.java)
    }

    else -> {
        @Suppress("DEPRECATION") getParcelable(key) as? T
    }
}
