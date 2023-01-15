package com.example.empattesttask.presentation.viewholder

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.empattesttask.BuildConfig
import com.example.empattesttask.R
import com.example.empattesttask.common.di.AppComponent
import com.example.empattesttask.common.utils.time.TimeUtil
import com.example.empattesttask.databinding.ItemDayBinding
import com.example.empattesttask.domain.model.entity.DayInfoEntity
import kotlin.math.roundToInt

class ForecastViewHolder(private val binding: ItemDayBinding, private val context: Context):
    ViewHolder(binding.root) {

    fun bind(item: DayInfoEntity) {
        with(binding) {
            tvDate.text = TimeUtil.millToDate(item.dt)
            tvWeatherDescription.text = item.weather[0].weatherDescription
            tvWeatherTemperature.text = item.main.temp.roundToInt().toString()
            tvWind.text = "${item.wind.speed} mp/h"
            tvHumidity.text = "${item.main.humidity} %"

            Log.i("ttt", "_${item.weather[0].icon}.png")

            Glide.with(context)
                .load(context.resources.getIdentifier("_${item.weather[0].icon}", "drawable", context.packageName))
                .into(ivWeatherIcon)
        }
    }

    companion object {
        fun from(parent: ViewGroup, context: Context): ForecastViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemDayBinding.inflate(inflater, parent, false)
            return ForecastViewHolder(binding, context)
        }
    }
}