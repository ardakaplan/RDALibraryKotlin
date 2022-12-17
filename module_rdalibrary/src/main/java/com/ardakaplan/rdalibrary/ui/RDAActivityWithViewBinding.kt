package com.ardakaplan.rdalibrary.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by Arda Kaplan at 15.09.2022 - 22:35
 *
 * ardakaplan101@gmail.com
 */
abstract class RDAActivityWithViewBinding<W : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: W

    protected fun setViewBinding(viewBinding: W) {

        this.binding = viewBinding

        setContentView(viewBinding.root)
    }
}