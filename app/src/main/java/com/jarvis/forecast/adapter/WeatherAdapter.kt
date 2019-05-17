package com.jarvis.forecast.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jarvis.forecast.R
import com.jarvis.forecast.bean.WeatherBean
import com.jarvis.forecast.util.Utils
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherAdapter :
    ListAdapter<WeatherBean, WeatherAdapter.ViewHolder>(object : DiffUtil.ItemCallback<WeatherBean>() {
        override fun areItemsTheSame(oldItem: WeatherBean, newItem: WeatherBean): Boolean {
            return oldItem.geometry.geometries[0].coordinates[0].toString() == newItem.geometry.geometries[0].coordinates[0].toString() &&
                    oldItem.geometry.geometries[0].coordinates[1].toString() == newItem.geometry.geometries[0].coordinates[1].toString()
        }

        override fun areContentsTheSame(oldItem: WeatherBean, newItem: WeatherBean): Boolean {
            return oldItem == newItem
        }
    }) {

    lateinit var mContext: Context
    lateinit var requestOptions: RequestOptions
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        requestOptions = RequestOptions().error(R.mipmap.error).placeholder(R.mipmap.loding)
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_weather, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = getItem(position)

        val todayPeriod = item.properties.periods.find { it.isDaytime }

        holder.itemView.cityNameTV.text = Utils.getCityNameByPoint(item.geometry.geometries[0].coordinates)

        Glide.with(mContext)
            .load(todayPeriod?.icon)
            .apply(requestOptions)
            .into(holder.itemView.mapIV)

        holder.itemView.temperatureTV.text = String.format(
            mContext.getString(R.string.temperature_format),
            todayPeriod?.temperature.toString(), todayPeriod?.temperatureUnit
        )

        holder.itemView.shortForecastTV.text = String.format(mContext.getString(R.string.shortForecast_format),todayPeriod?.shortForecast)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
