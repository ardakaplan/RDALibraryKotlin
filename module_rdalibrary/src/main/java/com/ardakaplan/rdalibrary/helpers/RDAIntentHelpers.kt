package com.ardakaplan.rdalibrary.helpers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.ardakaplan.rdalibrary.ui.RDAActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Arda Kaplan at 7.04.2022 - 12:26
 *
 * ardakaplan101@gmail.com
 */
@Singleton
class RDAIntentHelpers @Inject constructor(
    @ApplicationContext var context: Context
) {

    fun getClearCacheIntent(cls: Class<*>?): Intent {

        return getClearCacheIntent(context, cls)
    }


    companion object {

        fun openUrlInBrowser(activity: RDAActivity<*>, url: String) {

            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        fun openApplicationSettingsPage(activity: AppCompatActivity) {

            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + activity.packageName))
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            activity.startActivity(intent)
        }

        fun shareText(activity: Activity, textToShare: String) {

            ShareCompat.IntentBuilder(activity)
                .setText(textToShare)
                .setType("text/plain")
                .startChooser()
        }

        fun getClearCacheIntent(context: Context?, cls: Class<*>?): Intent {

            return Intent(context, cls).apply {

                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            }
        }
    }
}