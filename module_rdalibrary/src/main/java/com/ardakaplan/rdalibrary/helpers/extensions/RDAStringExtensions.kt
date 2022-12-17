package com.ardakaplan.rdalibrary.helpers.extensions

import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorInt
import java.util.regex.Pattern


/**
 * Created by Arda Kaplan at 23.04.2022 - 22:48
 *
 * ardakaplan101@gmail.com
 */

const val EMPTY = ""

fun String.isValidEmail(): Boolean {

    return Pattern.compile(".+@.+\\.[a-z]+").matcher(this).matches()
}


fun String.makeColor(@ColorInt color: Int, startingPoint: Int): SpannableString {

    val spannableString = SpannableString(this)

    spannableString.setSpan(ForegroundColorSpan(color), startingPoint, this.length, 0)

    return spannableString
}



