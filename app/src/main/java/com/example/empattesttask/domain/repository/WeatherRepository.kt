package com.example.empattesttask.domain.repository

import com.example.empattesttask.common.utils.result.Result
import com.example.empattesttask.domain.model.entity.WeatherEntity

interface WeatherRepository {
    suspend fun getForecast(city: String, countOfDays: String, key: String): Result<WeatherEntity>
}