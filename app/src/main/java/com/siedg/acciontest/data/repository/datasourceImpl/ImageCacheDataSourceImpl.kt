package com.siedg.acciontest.data.repository.datasourceImpl

import com.siedg.acciontest.data.model.Image
import com.siedg.acciontest.data.repository.datasource.ImageCacheDataSource

class ImageCacheDataSourceImpl : ImageCacheDataSource {
    private var imageList = ArrayList<Image>()
    override suspend fun saveImagesToCache(images: List<Image>) {
        imageList.clear()
        imageList = ArrayList(images)
    }

    override suspend fun getImagesFromCache(): List<Image> {
        return imageList
    }
}