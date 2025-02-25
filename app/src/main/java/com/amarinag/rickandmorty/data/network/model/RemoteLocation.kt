package com.amarinag.rickandmorty.data.network.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteLocation(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("url")
    @Expose
    val url: String?
)