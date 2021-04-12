package com.siedg.acciontest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siedg.acciontest.domain.GetImagesUseCase

class HomeViewModelFactory(
    private val getImagesUseCase: GetImagesUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(getImagesUseCase) as T
        }
        throw IllegalArgumentException("Invalid Argument for view model")
    }
}
