package com.siedg.acciontest.presentation.dependencyInjection.core

import com.siedg.acciontest.presentation.dependencyInjection.home.HomeSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        CacheDataModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)

interface AppComponent {
    fun homeSubComponent(): HomeSubComponent.Factory
}