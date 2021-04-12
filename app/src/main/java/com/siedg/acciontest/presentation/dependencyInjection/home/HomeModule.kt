package com.siedg.acciontest.presentation.dependencyInjection.home

import dagger.Module
import dagger.Provides
import com.siedg.acciontest.domain.GetImagesUseCase
import com.siedg.acciontest.presentation.viewmodel.HomeViewModelFactory

@Module
class HomeModule {
    @HomeScope
    @Provides
    fun provideHomeViewModelFactory(
        getImagesUseCase: GetImagesUseCase
    ): HomeViewModelFactory {
        return HomeViewModelFactory(
            getImagesUseCase
        )
    }
}