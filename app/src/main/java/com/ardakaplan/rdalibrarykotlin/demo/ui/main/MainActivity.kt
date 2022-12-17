package com.ardakaplan.rdalibrarykotlin.demo.ui.main

import android.os.Bundle
import com.ardakaplan.rdalibrary.helpers.RDAResourcesHelpers
import com.ardakaplan.rdalibrarykotlin.demo.R
import com.ardakaplan.rdalibrarykotlin.demo.databinding.MainActivityBinding
import com.ardakaplan.rdalibrarykotlin.demo.ui.BaseActivity
import com.ardakaplan.rdalogger.RDALogger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding>() {

    @Inject
    lateinit var rdaResourcesHelpers : RDAResourcesHelpers

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        binding.test1Button.text = "LAHANA"

        binding.test1Button.setOnClickListener {

            RDALogger.info("test click " + rdaResourcesHelpers.getDp(R.dimen.test))
        }
    }

    override fun getViewBinding() : MainActivityBinding {
        return MainActivityBinding.inflate(layoutInflater)
    }

}