package com.example.empattesttask.domain.mapper

import com.example.empattesttask.data.dto.WeatherEntityResponse
import com.example.empattesttask.domain.model.entity.WeatherEntity

interface WeatherMapper {
    fun mapWeatherResponseToEntity(weatherEntityResponse: WeatherEntityResponse): WeatherEntity
}