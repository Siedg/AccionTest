package com.siedg.acciontest.presentation

import android.app.Application
import com.siedg.acciontest.BuildConfig
import com.siedg.acciontest.presentation.dependencyInjection.Injector
import com.siedg.acciontest.presentation.dependencyInjection.core.*
import com.siedg.acciontest.presentation.dependencyInjection.home.HomeSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.FILTER))
            .build()
    }

    override fun createHomeSubComponent(): HomeSubComponent =
        appComponent.homeSubComponent().create()
}