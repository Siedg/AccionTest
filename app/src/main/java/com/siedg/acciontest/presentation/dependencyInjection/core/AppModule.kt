package com.siedg.acciontest.presentation.dependencyInjection.core

import android.content.Context
import com.siedg.acciontest.presentation.dependencyInjection.home.HomeSubComponent
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [ HomeSubComponent::class ]
)
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideAppApplicationContext(): Context {
        return context.applicationContext
    }
}
