package com.example.empattesttask.data.di

import com.example.empattesttask.data.network.api.WeatherDataProvider
import com.example.empattesttask.data.network.api.WeatherHelper
import com.example.empattesttask.data.network.api.WeatherService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataProviderModule {
    @Provides
    @Singleton
    fun provideWeatherDataProvider(
        weatherService: WeatherService
    ): WeatherHelper = WeatherDataProvider(weatherService)


}