package com.example.empattesttask.domain.repository

import com.example.empattesttask.common.utils.result.Result
import com.example.empattesttask.common.utils.result.map
import com.example.empattesttask.data.dto.WeatherEntityResponse
import com.example.empattesttask.data.network.api.WeatherHelper
import com.example.empattesttask.domain.mapper.WeatherMapper
import com.example.empattesttask.domain.model.entity.WeatherEntity
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherHelper: WeatherHelper,
    private val weatherMapper: WeatherMapper
): WeatherRepository {
    override suspend fun getForecast(
        city: String,
        countOfDays: String,
        key: String
    ): Result<WeatherEntity> {
        return weatherHelper.getForecast(city, countOfDays, key).map {
            weatherMapper.mapWeatherResponseToEntity(it)
        }
    }

}