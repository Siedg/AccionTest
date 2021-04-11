package com.siedg.acciontest.presentation.dependencyInjection.core

import com.siedg.acciontest.data.repository.datasource.ImageCacheDataSource
import com.siedg.acciontest.data.repository.datasourceImpl.ImageCacheDataSourceImpl
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideImageCacheDataSource(): ImageCacheDataSource {
        return ImageCacheDataSourceImpl()
    }
}
