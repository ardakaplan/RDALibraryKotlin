package com.ardakaplan.rdalibrarykotlin.demo

import com.ardakaplan.rdalibrary.RDAApplication
import com.ardakaplan.rdalogger.RDALoggerConfig
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Arda Kaplan at 18.12.2022 - 01:23
 *
 * ardakaplan101@gmail.com
 */
@HiltAndroidApp
class TestApplication : RDAApplication() {

    override fun onCreate() {
        super.onCreate()

        RDALoggerConfig.setup(getString(R.string.app_name)).enableLogging(true)

    }
}