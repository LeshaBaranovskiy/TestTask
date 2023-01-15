package com.example.empattesttask.presentation.di.presentation.provider

import com.example.empattesttask.presentation.activity.InitialActivity
import com.example.empattesttask.presentation.activity.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityProvider {
    @ContributesAndroidInjector
    abstract fun provideSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun provideInitialActivity(): InitialActivity
}