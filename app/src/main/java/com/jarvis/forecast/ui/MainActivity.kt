package com.jarvis.forecast.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jarvis.forecast.R
import com.jarvis.forecast.adapter.WeatherAdapter
import com.jarvis.forecast.bean.LocationBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel

    private val locationArray = arrayListOf<LocationBean>()

    private val adapter = WeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locationArray.add(LocationBean("Chicago", "41.39", "-87.34"))
        locationArray.add(LocationBean("New York", "40.425167", "-74.02150"))
        locationArray.add(LocationBean("Miami", "25.46", "-80.12"))
        locationArray.add(LocationBean("San Francisco", "37.480", "-122.250"))
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        recyclerView.adapter = adapter
        progressBar.visibility = View.VISIBLE
        viewModel.getWeatherForecast(locationArray)
        viewModel.liveData.observe(this, Observer {
            if (progressBar.visibility == View.VISIBLE) {
                progressBar.visibility = View.GONE
            }
            adapter.submitList(it)
        })
    }
}
