package com.jarvis.forecast

import android.app.Application
import com.jarvis.forecast.repository.DataRepository

class WeatherApp : Application(){

    fun getRepository(): DataRepository {
        return DataRepository.instance
    }
}