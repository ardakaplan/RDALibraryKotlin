package com.ardakaplan.rdalibrary.helpers

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Arda Kaplan at 6.01.2022 - 11:21
 *
 * ardakaplan101@gmail.com
 */
@Singleton
class RDASharedHelpers @Inject constructor(
    @ApplicationContext private var context: Context
) {

    private fun getSharedPreferences(): SharedPreferences {

        return context.getSharedPreferences(
            context.applicationInfo.loadLabel(context.packageManager).toString(),
            Context.MODE_PRIVATE
        )
    }

    fun getString(key: String?, defaultValue: String?): String? {

        return getSharedPreferences().getString(key, defaultValue)
    }

    fun putString(key: String, value: String) {

        getSharedPreferences().edit().putString(key, value).apply()
    }

    fun getInt(key: String?, defaultValue: Int): Int {

        return getSharedPreferences().getInt(key, defaultValue)
    }

    fun putInt(key: String?, value: Int) {

        getSharedPreferences().edit().putInt(key, value).apply()
    }

    fun getBoolean(key: String?, defaultValue: Boolean): Boolean {
        return getSharedPreferences().getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {

        getSharedPreferences().edit().putBoolean(key, value).apply()
    }

    fun getLong(key: String, defaultValue: Long): Long? {

        return getSharedPreferences().getLong(key, defaultValue)
    }

    fun putLong(key: String, value: Long) {

        getSharedPreferences().edit().putLong(key, value).apply()
    }

    fun delete(key: String) {

        getSharedPreferences().edit().remove(key).apply()
    }

    fun deleteAll() {

        getSharedPreferences().edit().clear().apply()
    }
}