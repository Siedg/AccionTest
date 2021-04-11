package com.siedg.acciontest.data.model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("Images")
    val images: List<Image>
)

fun Data.mapToImage() : Image = this.images[0]