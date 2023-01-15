package com.example.empattesttask.data.di

import android.content.Context
import com.example.empattesttask.common.Application
import com.example.empattesttask.data.local.AppDatabase
import com.example.empattesttask.data.local.dao.FavouriteCitiesDao
import com.example.empattesttask.data.local.dao.WeatherDao
import com.example.empattesttask.data.local.localdataprovider.LocalFavouriteCitiesDataProvider
import com.example.empattesttask.data.local.localdataprovider.LocalWeatherDataProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideWeatherDao(appDatabase: AppDatabase): WeatherDao =
        appDatabase.getWeatherDao()

    @Singleton
    @Provides
    fun provideFavouriteCitiesDao(appDatabase: AppDatabase): FavouriteCitiesDao =
        appDatabase.getFavouriteCitiesDao()

    @Singleton
    @Provides
    fun provideLocalWeatherDataProvider(
        weatherDao: WeatherDao
    ): LocalWeatherDataProvider =
        LocalWeatherDataProvider(weatherDao)

    @Singleton
    @Provides
    fun provideLocalFavouriteCitiesDataProvider(
        favouriteCitiesDao: FavouriteCitiesDao
    ): LocalFavouriteCitiesDataProvider =
        LocalFavouriteCitiesDataProvider(favouriteCitiesDao)

    @Singleton
    @Provides
    fun provideDBInstance(context: Context): AppDatabase =
        AppDatabase.getAppDataBase(context)

    @Singleton
    @Provides
    fun provideAppContext(application: Application): Context =
        application.applicationContext
}