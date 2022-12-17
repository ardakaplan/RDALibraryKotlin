package com.ardakaplan.rdalibrary.data.properties.shared

import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers

/**
 * Created by Arda Kaplan at 6.01.2022 - 11:20
 *
 * ardakaplan101@gmail.com
 */
abstract class RDASharedProperty<W>(val rdaSharedHelpers : RDASharedHelpers) {

    open fun saveValue(w : W) {

        when (w) {

            is Int -> {

                rdaSharedHelpers.putInt(getKey(), w as Int)
            }

            is String -> {

                rdaSharedHelpers.putString(getKey(), w as String)
            }

            is Boolean -> {

                rdaSharedHelpers.putBoolean(getKey(), w as Boolean)
            }

            is Long -> {

                rdaSharedHelpers.putLong(getKey(), w as Long)
            }
        }
    }

    protected fun getIntegerValue() : Int {

        return rdaSharedHelpers.getInt(getKey(), getDefault() as Int)
    }

    protected fun getStringValue() : String? {

        return rdaSharedHelpers.getString(getKey(), getDefault() as? String)
    }

    protected fun getBooleanValue() : Boolean {

        return rdaSharedHelpers.getBoolean(getKey(), getDefault() as Boolean)
    }

    protected fun getLongValue() : Long? {

        return rdaSharedHelpers.getLong(getKey(), getDefault() as Long)
    }

    fun delete() {
        rdaSharedHelpers.delete(getKey())
    }

    abstract fun getDefault() : W?

    abstract fun getValue() : W?

    protected abstract fun getKey() : String
}