package com.jarvis.forecast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jarvis.forecast.R
import com.jarvis.forecast.net.ApiErrorResponse
import com.jarvis.forecast.net.ApiSuccessResponse

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getWeatherForecast().observe(this, Observer {


            when (it) {
                is ApiSuccessResponse -> {
                    Log.e("s", it.body.toString())
                }
                is ApiErrorResponse -> {
                    Log.e("s", it.errorMessage)
                }
            }
        })
    }
}
