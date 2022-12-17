package com.ardakaplan.rdalibrary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by Arda Kaplan at 1.01.2022 - 22:36
 *
 * ardakaplan101@gmail.com
 */
abstract class RDAActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViewBinding()
    }

    private fun setViewBinding() {

        this.binding = getViewBinding()

        setContentView(binding.root)
    }

    abstract fun getViewBinding(): VB
}

