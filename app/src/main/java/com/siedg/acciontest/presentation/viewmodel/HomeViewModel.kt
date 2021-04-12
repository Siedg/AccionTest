package com.siedg.acciontest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.siedg.acciontest.domain.GetImagesUseCase

class HomeViewModel (
    private val getImagesUseCase: GetImagesUseCase
): ViewModel(){

    fun getImages() = liveData {
        val imageList = getImagesUseCase.execute()
        emit(imageList)
    }

}