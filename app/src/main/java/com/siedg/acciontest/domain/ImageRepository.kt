package com.siedg.acciontest.domain

import com.siedg.acciontest.data.model.Image

interface ImageRepository {
    suspend fun getImages(): List<Image>?
}