package com.siedg.acciontest.data.repository.datasource

import com.siedg.acciontest.data.model.ImageList
import retrofit2.Response

interface ImageRemoteDataSource {
    suspend fun getImages(): Response<ImageList>
}