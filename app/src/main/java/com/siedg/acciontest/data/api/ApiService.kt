package com.siedg.acciontest.data.api

import com.siedg.acciontest.data.model.ImageList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization: Client-ID 7b84fe6cc8c231a")
    @GET("gallery/search")
    suspend fun getImages(@Query("q") filter:String): Response<ImageList>
}