package com.jarvis.forecast.util

import java.lang.NumberFormatException

object Utils {

    fun getCityNameByPoint(list: List<Any>): String {
        if (list.size == 2) {
            try {
                val longitude = list[0].toString().toDouble().toInt()
                val latitude = list[1].toString().toDouble().toInt()

                when {
                    longitude == -87 && latitude == 41 -> return "Chicago"
                    longitude == -74 && latitude == 40 -> return "New York"
                    longitude == -80 && latitude == 25 -> return "Miami"
                    longitude == -122 && latitude == 37 -> return "San Francisco"
                }
            } catch (except: NumberFormatException) {
                return ""
            }
        }
        return ""
    }
}