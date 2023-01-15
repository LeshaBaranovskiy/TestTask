package com.example.empattesttask.domain.di

import com.example.empattesttask.data.local.localdataprovider.LocalFavouriteCitiesDataProvider
import com.example.empattesttask.data.local.localdataprovider.LocalWeatherDataProvider
import com.example.empattesttask.data.network.api.WeatherHelper
import com.example.empattesttask.domain.mapper.WeatherMapper
import com.example.empattesttask.domain.repository.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideWeatherRepository(
        weatherHelper: WeatherHelper,
        weatherMapper: WeatherMapper
    ): WeatherRepository =
        WeatherRepositoryImpl(
            weatherHelper, weatherMapper
        )

    @Singleton
    @Provides
    fun provideLocalDbWeatherRepository(
        localWeatherDataProvider: LocalWeatherDataProvider
    ): LocalDbWeatherRepository = LocalDbWeatherRepositoryImpl(
        localWeatherDataProvider
    )

    @Singleton
    @Provides
    fun provideFavouriteCitiesRepository(
        favouriteCitiesDataProvider: LocalFavouriteCitiesDataProvider
    ): FavouriteCitiesRepository = FavouriteCitiesRepositoryImpl(
        favouriteCitiesDataProvider
    )
}