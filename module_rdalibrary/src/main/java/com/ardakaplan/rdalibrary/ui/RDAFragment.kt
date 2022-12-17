package com.ardakaplan.rdalibrary.ui

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Created by Arda Kaplan at 7.04.2022 - 13:02
 *
 * ardakaplan101@gmail.com
 */
abstract class RDAFragment<W : ViewBinding> : Fragment() {

    protected lateinit var binding: W

    protected open fun getContainerActivity(): RDAActivity<*> {

        return activity as RDAActivity<*>
    }
}