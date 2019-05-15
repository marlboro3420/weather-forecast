package com.jarvis.forecast.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.jarvis.forecast.WeatherApp
import com.jarvis.forecast.bean.WeatherBean
import com.jarvis.forecast.net.ApiResponse
import com.jarvis.forecast.repository.DataRepository

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    var dataRepository: DataRepository = (application as WeatherApp).getRepository()

    fun getWeatherForecast():LiveData<ApiResponse<WeatherBean>>{
        return dataRepository.getWeatherForecast()
    }
}