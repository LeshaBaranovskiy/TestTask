package com.example.empattesttask.data.network.api

import com.example.empattesttask.common.utils.result.Result
import com.example.empattesttask.data.dto.WeatherEntityResponse
import javax.inject.Inject

class WeatherDataProvider @Inject constructor(
    private val weatherService: WeatherService
): WeatherHelper {
    override suspend fun getForecast(city: String, countOfDays: String, key: String): Result<WeatherEntityResponse> =
        weatherService.getForecast("metric", city, countOfDays, key)
}