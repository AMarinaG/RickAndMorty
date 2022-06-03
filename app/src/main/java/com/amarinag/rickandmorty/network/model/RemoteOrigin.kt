package com.amarinag.rickandmorty.network.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class RemoteOrigin(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("url")
    @Expose
    val url: String?
)