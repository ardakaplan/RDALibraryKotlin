package com.ardakaplan.rdalibrary.helpers

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Arda Kaplan at 5.05.2022 - 12:30
 *
 * ardakaplan101@gmail.com
 */
@Singleton
class RDAResourcesHelpers @Inject constructor(
    @ApplicationContext private var context: Context
) {

    fun getDp(@DimenRes dimenId: Int): Float {

        return Companion.getDp(context, dimenId)
    }

    fun applyFont(text: String, @FontRes fontId: Int): SpannableStringBuilder {

        val spannableStringBuilder = SpannableStringBuilder(text)

        spannableStringBuilder.setSpan(
            CustomTypefaceSpan(
                "",
                ResourcesCompat.getFont(context, fontId)!!
            ),
            0,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        )

        return spannableStringBuilder
    }

    companion object {

        fun getDp(context: Context, @DimenRes dimenId: Int): Float {

            return context.resources.getDimension(dimenId)
        }

        fun changeViewBackgroundSolidColor(view: View, @ColorInt color: Int) {

            changeSolidColor(view.background as GradientDrawable, color)
        }


        @Suppress("MemberVisibilityCanBePrivate")
        fun changeSolidColor(drawable: GradientDrawable, @ColorInt color: Int) {

            drawable.setColor(color)

            drawable.mutate()
        }

    }
}