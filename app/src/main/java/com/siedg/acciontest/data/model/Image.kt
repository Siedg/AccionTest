package com.siedg.acciontest.data.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("link")
    val link: String,
    @SerializedName("type")
    val type: String
)