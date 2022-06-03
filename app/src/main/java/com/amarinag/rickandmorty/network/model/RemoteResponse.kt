package com.amarinag.rickandmorty.network.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteResponse<T>(
    @SerializedName("info")
    @Expose
    val info: RemoteInfo?,
    @SerializedName("results")
    @Expose
    val results: T?
)