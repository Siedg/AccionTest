package com.siedg.acciontest.presentation.dependencyInjection.core

import com.siedg.acciontest.data.api.ApiService
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetModule(private val baseUrl: String) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun providesAPIService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}
