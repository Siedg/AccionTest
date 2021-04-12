package com.siedg.acciontest.data.model

import com.google.gson.annotations.SerializedName

data class ImageList(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean
)

fun ImageList.mapToImage() : List<Image>{
    return this.data.map { value -> value.mapToImage() }
}