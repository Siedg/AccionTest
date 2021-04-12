package com.siedg.acciontest.presentation.dependencyInjection.core

import com.siedg.acciontest.data.api.ApiService
import com.siedg.acciontest.data.repository.datasource.ImageRemoteDataSource
import com.siedg.acciontest.data.repository.datasourceImpl.ImageRemoteDataSourceImpl
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideImageRemoteDataSource(apiService: ApiService): ImageRemoteDataSource {
        return ImageRemoteDataSourceImpl(apiService, apiKey)
    }
}