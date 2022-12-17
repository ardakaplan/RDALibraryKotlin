package com.ardakaplan.rdalibrary.ui.adapters

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ardakaplan.rdalibrary.ui.data.RDATabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.ref.WeakReference
import java.util.*

/**
 * Created by Arda Kaplan at 7.04.2022 - 23:24
 *
 * ardakaplan101@gmail.com
 */
abstract class RDATabAdapter(
    protected val activity: FragmentActivity,
    protected val tabLayout: TabLayout,
    private val viewPager2: ViewPager2,
    protected val tabItemList: MutableList<RDATabItem>

) : FragmentStateAdapter(activity) {

    private var fragmentReferences: Hashtable<Int, WeakReference<Fragment>> = Hashtable()

    init {

        viewPager2.offscreenPageLimit = tabItemList.size
    }

    override fun getItemCount(): Int {

        return tabItemList.size
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        TabLayoutMediator(tabLayout, viewPager2) { _, _ -> }.attach()

        setUpTabViews()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {

                adjustSelectionColorToTabLayout(tab, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

                adjustSelectionColorToTabLayout(tab, false)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        adjustSelectionColorToTabLayout(tabLayout.getTabAt(0)!!, true)
    }

    protected fun getTabItem(position: Int): RDATabItem {

        return tabItemList[position]
    }

    open fun getFragment(position: Int): Fragment? {

        return fragmentReferences[position]?.get()
    }

    override fun createFragment(position: Int): Fragment {

        val fragment = getTabItem(position).fragment

        fragmentReferences[position] = WeakReference(fragment)

        return fragment!!
    }

    protected fun getDrawable(@DrawableRes drawableId: Int): Drawable? {

        return ContextCompat.getDrawable(activity, drawableId)
    }

    @ColorInt
    protected fun getColor(@ColorRes colorId: Int): Int {

        return ContextCompat.getColor(activity, colorId)
    }

    protected abstract fun adjustSelectionColorToTabLayout(tab: TabLayout.Tab, isSelected: Boolean)

    protected abstract fun setUpTabViews()
}

