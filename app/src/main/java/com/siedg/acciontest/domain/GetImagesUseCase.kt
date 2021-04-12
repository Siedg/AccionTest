package com.siedg.acciontest.domain;

import com.siedg.acciontest.data.model.Image;

class GetImagesUseCase(private val imageRepository: ImageRepository) {
    suspend fun execute():List<Image>? = imageRepository.getImages()
}