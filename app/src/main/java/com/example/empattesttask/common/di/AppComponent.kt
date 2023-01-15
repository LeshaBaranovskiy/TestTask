package com.example.empattesttask.common.di

import com.example.empattesttask.common.Application
import com.example.empattesttask.domain.di.DomainModule
import com.example.empattesttask.domain.di.ViewModelModule
import com.example.empattesttask.presentation.di.ApplicationModule
import com.example.empattesttask.presentation.fragment.BaseFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        DomainModule::class,
        ViewModelModule::class,
        UtilsModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}