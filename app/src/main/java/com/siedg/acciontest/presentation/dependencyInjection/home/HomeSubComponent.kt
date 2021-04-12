package com.siedg.acciontest.presentation.dependencyInjection.home

import com.siedg.acciontest.presentation.ui.HomeFragment
import com.siedg.acciontest.presentation.ui.MainActivity
import dagger.Subcomponent

@HomeScope
@Subcomponent(modules = [HomeModule::class])
interface HomeSubComponent{
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): HomeSubComponent
    }
}