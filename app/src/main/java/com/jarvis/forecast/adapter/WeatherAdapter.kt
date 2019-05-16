package com.jarvis.forecast.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jarvis.forecast.R
import com.jarvis.forecast.bean.WeatherBean
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherAdapter : ListAdapter<WeatherBean, WeatherAdapter.ViewHolder>(object : DiffUtil.ItemCallback<WeatherBean>() {
    override fun areItemsTheSame(oldItem: WeatherBean, newItem: WeatherBean): Boolean {
        return oldItem.geometry.geometries[0].coordinates[0] == newItem.geometry.geometries[0].coordinates[0] &&
                oldItem.geometry.geometries[0].coordinates[1] == newItem.geometry.geometries[0].coordinates[1]
    }

    override fun areContentsTheSame(oldItem: WeatherBean, newItem: WeatherBean): Boolean {
        return oldItem == newItem
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_weather, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = getItem(position)
        holder.itemView.textTV.text = item.properties.periods.find { it.isDaytime }?.shortForecast
                ?: "---"
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
