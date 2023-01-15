package com.example.empattesttask.common.di

import com.example.empattesttask.common.utils.result.error.ErrorIdentifier
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {
    @Provides
    fun provideErrorIdentifier(): ErrorIdentifier {
        return ErrorIdentifier()
    }
}