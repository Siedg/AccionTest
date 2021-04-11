package com.siedg.acciontest.presentation.dependencyInjection.core

import com.siedg.acciontest.domain.GetImagesUseCase
import com.siedg.acciontest.domain.ImageRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetImagesUseCase(repository: ImageRepository): GetImagesUseCase {
        return GetImagesUseCase(repository)
    }
}
