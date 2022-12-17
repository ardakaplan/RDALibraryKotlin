package com.ardakaplan.rdalibrary.data.objects

import com.ardakaplan.rdalibrary.helpers.RDAJsonHelpers
import com.google.gson.GsonBuilder

/**
 * Created by Arda Kaplan at 25.04.2022 - 23:16
 *
 * ardakaplan101@gmail.com
 */
abstract class RDAObject {

    override fun toString(): String {
        return RDAJsonHelpers.objectToJson(this)
    }

    fun getPrettyPrintAsString(): String {

        return GsonBuilder().setPrettyPrinting().create().toJson(this)
    }
}