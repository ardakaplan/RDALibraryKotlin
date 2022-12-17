package com.ardakaplan.rdalibrary.helpers.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * Created by Arda Kaplan at 7.04.2022 - 12:32
 *
 * ardakaplan101@gmail.com
 */
inline fun <reified T : Activity> Context.startActivity(
    block: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)

    startActivity(intent, block)
}

inline fun Context.startActivity(
    intent: Intent,
    block: Intent.() -> Unit = {}
) {
    block(intent)
    startActivity(intent)
}

inline fun <reified T : Activity> Context.startActivity() {

    startActivity<T> {}
}
