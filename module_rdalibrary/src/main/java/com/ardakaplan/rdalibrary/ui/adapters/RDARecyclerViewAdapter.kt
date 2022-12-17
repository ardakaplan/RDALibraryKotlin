package com.ardakaplan.rdalibrary.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Arda Kaplan at 23.04.2022 - 01:07
 *
 * ardakaplan101@gmail.com
 */
abstract class RDARecyclerViewAdapter<ItemObject, VH : RecyclerView.ViewHolder>(
    var dataList: MutableList<ItemObject>
) : RecyclerView.Adapter<VH>() {

    constructor() : this(
        mutableListOf<ItemObject>()
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        return getViewHolderInstance(LayoutInflater.from(parent.context).inflate(getItemLayout(), parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    protected fun getItem(position: Int): ItemObject {
        return dataList[position]
    }

    fun setData(dataList: MutableList<ItemObject>) {

        this.dataList = dataList

        notifyDataSetChanged()
    }

    @LayoutRes
    protected abstract fun getItemLayout(): Int

    protected abstract fun getViewHolderInstance(view: View): VH
}