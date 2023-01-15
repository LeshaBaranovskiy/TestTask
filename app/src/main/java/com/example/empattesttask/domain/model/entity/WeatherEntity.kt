package com.example.empattesttask.domain.model.entity

data class WeatherEntity(
    val list: List<DayInfoEntity>
)

data class DayInfoEntity(
    val dt: Long,
    val main: DayInfoMainInfoEntity,
    val weather: List<DayInfoWeatherEntity>,
    val wind: DayInfoWindEntity
)

data class DayInfoMainInfoEntity(
    val temp: Float,
    val humidity: Int
)

data class DayInfoWeatherEntity(
    val id: Int,
    val weatherTitle: String,
    val weatherDescription: String,
    val icon: String
)

data class DayInfoWindEntity(
    val speed: Float
)