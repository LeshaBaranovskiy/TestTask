package com.example.empattesttask.domain.di

import com.example.empattesttask.domain.mapper.WeatherMapper
import com.example.empattesttask.domain.mapper.WeatherMapperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {
    @Provides
    @Singleton
    fun providesWeatherMapper(): WeatherMapper = WeatherMapperImpl()
}