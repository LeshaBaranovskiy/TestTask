package com.example.empattesttask.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherEntityResponse(
    @SerializedName("list")
    val list: List<DayInfoEntityResponse>
)

data class DayInfoEntityResponse(
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("main")
    val main: DayInfoMainInfoEntityResponse,
    @SerializedName("weather")
    val weather: List<DayInfoWeatherEntityResponse>,
    @SerializedName("wind")
    val wind: DayInfoWindEntityResponse
)

data class DayInfoMainInfoEntityResponse(
    @SerializedName("temp")
    val temp: Float,
    @SerializedName("humidity")
    val humidity: Int
)

data class DayInfoWeatherEntityResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val weatherTitle: String,
    @SerializedName("description")
    val weatherDescription: String,
    @SerializedName("icon")
    val icon: String
)

data class DayInfoWindEntityResponse(
    @SerializedName("speed")
    val speed: Float
)