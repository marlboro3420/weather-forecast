package com.jarvis.forecast.repository

import androidx.lifecycle.LiveData
import com.jarvis.forecast.bean.WeatherBean
import com.jarvis.forecast.net.ApiResponse
import com.jarvis.forecast.net.ApiStores
import com.jarvis.forecast.net.AppClient


class DataRepository private constructor() {
    private val apiStores = AppClient.mRetrofit.create(ApiStores::class.java)

    fun getWeatherForecast(latitude: String, longitude: String): LiveData<ApiResponse<WeatherBean>> {

        return apiStores.getWeatherForecast(latitude,longitude)
    }

    companion object {
        val instance: DataRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            DataRepository()
        }
    }

}
