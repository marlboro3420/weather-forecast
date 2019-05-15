package com.jarvis.forecast.bean


import com.google.gson.annotations.SerializedName

data class WeatherBean(
//    @SerializedName("geometry")
//    val geometry: Geometry,
    @SerializedName("properties")
    val properties: Properties,
    @SerializedName("type")
    val type: String
//    @SerializedName("")
//    @context x: List<String>
) {
    data class Properties(
        @SerializedName("elevation")
        val elevation: Elevation,
        @SerializedName("forecastGenerator")
        val forecastGenerator: String,
        @SerializedName("generatedAt")
        val generatedAt: String,
        @SerializedName("periods")
        val periods: List<Period>,
        @SerializedName("units")
        val units: String,
        @SerializedName("updateTime")
        val updateTime: String,
        @SerializedName("updated")
        val updated: String,
        @SerializedName("validTimes")
        val validTimes: String
    ) {
        data class Period(
            @SerializedName("detailedForecast")
            val detailedForecast: String,
            @SerializedName("endTime")
            val endTime: String,
            @SerializedName("icon")
            val icon: String,
            @SerializedName("isDaytime")
            val isDaytime: Boolean,
            @SerializedName("name")
            val name: String,
            @SerializedName("number")
            val number: Int,
            @SerializedName("shortForecast")
            val shortForecast: String,
            @SerializedName("startTime")
            val startTime: String,
            @SerializedName("temperature")
            val temperature: Int,
            @SerializedName("temperatureTrend")
            val temperatureTrend: Any,
            @SerializedName("temperatureUnit")
            val temperatureUnit: String,
            @SerializedName("windDirection")
            val windDirection: String,
            @SerializedName("windSpeed")
            val windSpeed: String
        )

        data class Elevation(
            @SerializedName("unitCode")
            val unitCode: String,
            @SerializedName("value")
            val value: Double
        )
    }

//    data class Geometry(
//        @SerializedName("geometries")
//        val geometries: List<Geometry>,
//        @SerializedName("type")
//        val type: String
//    ) {
//        data class Geometry(
//            @SerializedName("coordinates")
//            val coordinates: List<List<Any>>,
//            @SerializedName("type")
//            val type: String
//        )
//    }
}