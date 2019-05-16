package com.jarvis.forecast.net


import androidx.lifecycle.LiveData
import com.jarvis.forecast.bean.WeatherBean
import retrofit2.http.*


interface ApiStores {
    @GET("/points/{latitude},{longitude}/forecast")
    fun getWeatherForecast(@Path("latitude") latitude: String,@Path("longitude") longitude: String): LiveData<ApiResponse<WeatherBean>>
}