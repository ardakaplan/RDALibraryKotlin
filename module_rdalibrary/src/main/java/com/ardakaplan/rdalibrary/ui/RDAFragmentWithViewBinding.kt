package com.ardakaplan.rdalibrary.ui

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Created by Arda Kaplan at 15.09.2022 - 22:35
 *
 * ardakaplan101@gmail.com
 */
class RDAFragmentWithViewBinding<W : ViewBinding> : Fragment() {

    protected lateinit var binding: W

    protected open fun getContainerActivity(): RDAActivityWithViewBinding<*> {

        return activity as RDAActivityWithViewBinding<*>
    }
}