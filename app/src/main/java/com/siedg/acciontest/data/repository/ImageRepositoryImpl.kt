package com.siedg.acciontest.data.repository;

import android.util.Log
import com.siedg.acciontest.data.model.Image
import com.siedg.acciontest.data.repository.datasource.ImageCacheDataSource;
import com.siedg.acciontest.data.repository.datasource.ImageRemoteDataSource;
import com.siedg.acciontest.domain.ImageRepository
import java.lang.Exception

class ImageRepositoryImpl (
    private val imageRemoteDataSource: ImageRemoteDataSource,
    private val imageCacheDataSource: ImageCacheDataSource
) : ImageRepository {
    override suspend fun getImages(): List<Image>? = getImagesFromCache()

    private suspend fun getImagesFromCache(): List<Image> {
        lateinit var imageList: List<Image>
        try {
            imageList = imageCacheDataSource.getImagesFromCache()
        } catch (e: Exception) {
            Log.i("CACHE-ERROR", e.message.toString())
        }
        if (imageList.isEmpty()) {
            imageList = getImagesFromAPI()
            imageCacheDataSource.saveImagesToCache(imageList)
        }
        return imageList
    }

    private suspend fun getImagesFromAPI(): List<Image> {
        val imageList: MutableList<Image> = mutableListOf()
        try {
            val response = imageRemoteDataSource.getImages()
            val body = response.body()
            body?.data?.forEach { image ->
                image.let {
                    if(!it.images.isNullOrEmpty() && "image/jpeg" == it.images[0].type) {
                        imageList.add(it.images[0])
                    }

                }
            }
        } catch (e: Exception) {
            Log.i("Error", e.message.toString())
        }
        return imageList
    }
}
