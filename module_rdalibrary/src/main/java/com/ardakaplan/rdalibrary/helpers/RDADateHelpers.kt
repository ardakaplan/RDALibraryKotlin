package com.ardakaplan.rdalibrary.helpers

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Arda Kaplan at 11.04.2022 - 15:32
 *
 * ardakaplan101@gmail.com
 */
class RDADateHelpers {

    companion object {

        const val ONE_SECOND_MILLIS : Long = 1000

        const val ONE_MINUTES_MILLIS = 60 * ONE_SECOND_MILLIS

        const val ONE_HOUR_MILLIS = 60 * ONE_MINUTES_MILLIS

        const val ONE_DAY_MILLIS = 24 * ONE_HOUR_MILLIS

        const val ONE_MINUTE_SECONDS = 60

        const val ONE_HOUR_SECONDS = 60 * ONE_MINUTE_SECONDS

        const val ONE_DAY_SECONDS = 24 * ONE_HOUR_SECONDS


        fun dateToCalendar(date : Date) : Calendar {
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar
        }

        fun getTodayCalendarWithGivenTime(serverTimeText : String) : Calendar? {
            val calendar = Calendar.getInstance()
            val hour = serverTimeText.substring(0, 2).toInt()
            val minute = serverTimeText.substring(2, 4).toInt()
            val second = serverTimeText.substring(4).toInt()
            calendar[Calendar.HOUR_OF_DAY] = hour
            calendar[Calendar.MINUTE] = minute
            calendar[Calendar.SECOND] = second
            return calendar
        }


        /**
         * @return sadece gün/ay/yıl karşılaştırması yapar, saat verisini göz ardı eder,
         * iki tarih bu karşılaştırmaya göre aynı ise true döner
         */
        fun isEqualByDate(date1 : Date, date2 : Date) : Boolean {
            val calendar1 = Calendar.getInstance()
            val calendar2 = Calendar.getInstance()
            calendar1.time = date1
            calendar2.time = date2
            return calendar1[Calendar.YEAR] == calendar2[Calendar.YEAR] &&
                    calendar1[Calendar.DAY_OF_YEAR] == calendar2[Calendar.DAY_OF_YEAR]
        }

        @Throws(ParseException::class)
        fun getDate(date : String, format : String, locale : Locale) : Date? {
            return SimpleDateFormat(format, locale).parse(date)
        }

        /**
         * @param miliSeconds  date miliseconds to convert
         * @param formatString formatting type
         * - dd MMMM yyyy HH:mm:ss
         * - dd MMM yyyy
         * - HH:mm:ss
         * - MM/dd/yyyy
         * - dd MMMM
         * - dd.MM.yyyy
         */
        fun formatDate(miliSeconds : Long, formatString : String, locale : Locale) : String {
            return formatDate(Date(miliSeconds), formatString, locale)
        }

        /**
         * @param date         date miliseconds to convert
         * @param formatString formatting type
         */
        fun formatDate(date : Date, formatString : String, locale : Locale) : String {
            return SimpleDateFormat(formatString, locale).format(date)
        }

        fun formatDate(calendar : Calendar, format : String, locale : Locale) : String {
            return SimpleDateFormat(format, locale).format(calendar.time)
        }
    }
}