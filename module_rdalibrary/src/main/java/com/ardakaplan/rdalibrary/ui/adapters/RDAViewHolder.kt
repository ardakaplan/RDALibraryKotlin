package com.ardakaplan.rdalibrary.ui.adapters

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Arda Kaplan at 27.07.2022 - 15:49
 *
 * ardakaplan101@gmail.com
 */
abstract class RDAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun getContext(): Context {

        return itemView.context
    }
}