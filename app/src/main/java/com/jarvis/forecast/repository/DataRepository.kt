package com.jarvis.forecast.repository

import androidx.lifecycle.LiveData
import com.jarvis.forecast.bean.WeatherBean
import com.jarvis.forecast.net.ApiResponse
import com.jarvis.forecast.net.ApiStores
import com.jarvis.forecast.net.AppClient


class DataRepository private constructor() {
    private val apiStores = AppClient.mRetrofit.create(ApiStores::class.java)

    fun getWeatherForecast(): LiveData<ApiResponse<WeatherBean>> {

        return apiStores.getWeatherForecast()
    }

    companion object {
        val instance: DataRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            DataRepository()
        }
    }

}
