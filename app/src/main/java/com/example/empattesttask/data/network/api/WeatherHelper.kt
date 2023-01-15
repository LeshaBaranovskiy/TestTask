package com.example.empattesttask.data.network.api

import com.example.empattesttask.common.utils.result.Result
import com.example.empattesttask.data.dto.WeatherEntityResponse

interface WeatherHelper {
    suspend fun getForecast(
        city: String,
        countOfDays: String,
        key: String
    ): Result<WeatherEntityResponse>
}