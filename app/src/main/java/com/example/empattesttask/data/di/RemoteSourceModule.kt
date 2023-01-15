package com.example.empattesttask.data.di

import com.example.empattesttask.common.utils.result.error.ErrorIdentifier
import com.example.empattesttask.data.network.source.RemoteDataSource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(
        gson: Gson,
        errorIdentifier: ErrorIdentifier
    ): RemoteDataSource =
        RemoteDataSource(
            gson,
            errorIdentifier
        )

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()
}