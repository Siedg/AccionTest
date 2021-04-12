package com.siedg.acciontest.presentation.dependencyInjection.core

import com.siedg.acciontest.data.repository.ImageRepositoryImpl
import com.siedg.acciontest.data.repository.datasource.ImageCacheDataSource
import com.siedg.acciontest.data.repository.datasource.ImageRemoteDataSource
import com.siedg.acciontest.domain.ImageRepository
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(
        remote: ImageRemoteDataSource,
        cache: ImageCacheDataSource
    ) : ImageRepository{
        return ImageRepositoryImpl(remote, cache)
    }
}