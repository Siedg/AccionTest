package com.siedg.acciontest.data.repository.datasourceImpl

import com.siedg.acciontest.data.api.ApiService
import com.siedg.acciontest.data.model.ImageList
import com.siedg.acciontest.data.repository.datasource.ImageRemoteDataSource
import retrofit2.Response

class ImageRemoteDataSourceImpl (
    private val service: ApiService,
    private val filter: String
): ImageRemoteDataSource {
    override suspend fun getImages(): Response<ImageList> = service.getImages(filter)
}
