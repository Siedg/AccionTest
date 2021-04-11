package com.siedg.acciontest.data.repository.datasource

import com.siedg.acciontest.data.model.Image

interface ImageCacheDataSource {
    suspend fun saveImagesToCache(images: List<Image>)

    suspend fun getImagesFromCache(): List<Image>
}