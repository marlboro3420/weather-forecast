package com.jarvis.forecast.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import com.jarvis.forecast.WeatherApp
import com.jarvis.forecast.bean.LocationBean
import com.jarvis.forecast.bean.WeatherBean
import com.jarvis.forecast.net.ApiErrorResponse
import com.jarvis.forecast.net.ApiSuccessResponse
import com.jarvis.forecast.repository.DataRepository

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    var dataRepository: DataRepository = (application as WeatherApp).getRepository()

    val liveData = MediatorLiveData<ArrayList<WeatherBean>>()

    /**
     * Get forecasts for cities in array
     */
    fun getWeatherForecast(arrayList: ArrayList<LocationBean>) {
        arrayList.forEach {
            liveData.addSource(dataRepository.getWeatherForecast(it.latitude, it.longitude)) { apiResponse ->
                when (apiResponse) {
                    is ApiSuccessResponse -> {
                        val tempArray = ArrayList<WeatherBean>()
                        if (!liveData.value.isNullOrEmpty()) {
                            tempArray.addAll(liveData.value!!)
                        }
                        tempArray.add(apiResponse.body)
                        liveData.value = tempArray
                    }
                    is ApiErrorResponse -> {//Should be handled in activity
                        Log.e("ApiErrorResponse", apiResponse.errorMessage)
                    }
                }
            }
        }
    }
}