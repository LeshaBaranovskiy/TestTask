package com.example.empattesttask.data.network.api

import com.example.empattesttask.data.dto.WeatherEntityResponse
import com.example.empattesttask.common.utils.result.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("units") units: String,
        @Query("q") city: String,
        @Query("cnt") countOfDays: String,
        @Query("appId") key: String,
    ): Result<WeatherEntityResponse>
}