package com.siedg.acciontest.presentation.dependencyInjection

import com.siedg.acciontest.presentation.dependencyInjection.home.HomeSubComponent

interface Injector {
    fun createHomeSubComponent(): HomeSubComponent
}