package com.example.empattesttask.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.empattesttask.domain.model.entity.DayInfoEntity
import com.example.empattesttask.presentation.viewholder.ForecastViewHolder

class ForecastAdapter(
    private val context: Context
): Adapter<ForecastViewHolder>() {
    private var weatherDay: List<DayInfoEntity> = mutableListOf()

    fun setWeatherList(weatherDay: List<DayInfoEntity>) {
        this.weatherDay = weatherDay
        notifyItemRangeChanged(0, weatherDay.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder.from(parent, context)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(weatherDay.get(position))
    }

    override fun getItemCount(): Int =
        weatherDay.size

}