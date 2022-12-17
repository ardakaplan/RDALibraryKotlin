package com.ardakaplan.rdalibrary.helpers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import java.io.StringReader
import java.lang.reflect.Type

/**
 * Created by Arda Kaplan at 17.04.2022 - 01:55
 *
 * ardakaplan101@gmail.com
 */
class RDAJsonHelpers {

    companion object {

        fun listToJson(list: List<*>?): String? {

            val gson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()

            return gson.toJsonTree(list).asJsonArray.toString()
        }

        /**
         * Type collectionType = new TypeToken<List></List><Player>>() { }.getType();
         *
         *
         * seklinde type verilerek kullanilir */
        fun jsonToList(json: String?, collectionType: Type?): ArrayList<*>? {

            val googleJson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()

            val reader: com.google.gson.stream.JsonReader = com.google.gson.stream.JsonReader(StringReader(json))

            reader.setLenient(true)

            return googleJson.fromJson<ArrayList<*>>(reader, collectionType)
        }

        fun objectToJson(`object`: Any?): String {

            return Gson().toJson(`object`)
        }

        @Throws(JsonSyntaxException::class)
        fun jsonToObject(json: String?, klass: Class<*>?): Any? {

            return Gson().fromJson(json, klass)
        }
    }


}