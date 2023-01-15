package com.example.empattesttask.domain.mapper

import com.example.empattesttask.data.dto.WeatherEntityResponse
import com.example.empattesttask.domain.model.entity.*

class WeatherMapperImpl: WeatherMapper {
    override fun mapWeatherResponseToEntity(weatherEntityResponse: WeatherEntityResponse): WeatherEntity {
        with(weatherEntityResponse) {
            return WeatherEntity(
                list.map {
                    DayInfoEntity(
                        it.dt,
                        DayInfoMainInfoEntity(it.main.temp, it.main.humidity),
                        listOf(DayInfoWeatherEntity(it.weather[0].id, it.weather[0].weatherTitle, it.weather[0].weatherDescription, it.weather[0].icon)),
                        DayInfoWindEntity(it.wind.speed)
                    )
                }
            )
        }
    }

}