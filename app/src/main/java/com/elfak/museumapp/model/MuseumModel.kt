package com.elfak.museumapp.model

import com.google.gson.annotations.SerializedName

data class MuseumModel(
    val guid: String = "",

    @SerializedName("item_name")
    val itemName: String = "",

    @SerializedName("artist_name")
    val artistName: String = "",

    val description: String = "",

    @SerializedName("image_url")
    val imageUrl: List<String> = emptyList(),
)