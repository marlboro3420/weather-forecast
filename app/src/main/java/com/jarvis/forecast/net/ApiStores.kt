package com.jarvis.forecast.net


import androidx.lifecycle.LiveData
import com.jarvis.forecast.bean.WeatherBean
import retrofit2.http.*


interface ApiStores {
    @GET("/gridpoints/LOX/157,43/forecast")
    fun getWeatherForecast(): LiveData<ApiResponse<WeatherBean>>
}