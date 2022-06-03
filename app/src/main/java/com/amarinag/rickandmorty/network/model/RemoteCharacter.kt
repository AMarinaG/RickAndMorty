package com.amarinag.rickandmorty.network.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class RemoteCharacter(
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("status")
    @Expose
    val status: String?,
    @SerializedName("species")
    @Expose
    val species: String?,
    @SerializedName("type")
    @Expose
    val type: String?,
    @SerializedName("gender")
    @Expose
    val gender: String?,
    @SerializedName("origin")
    @Expose
    val origin: RemoteOrigin?,
    @SerializedName("location")
    @Expose
    val location: RemoteLocation?,
    @SerializedName("image")
    @Expose
    val image: String?,
    @SerializedName("episode")
    @Expose
    val episode: List<String>?,
    @SerializedName("url")
    @Expose
    val url: String?,
    @SerializedName("created")
    @Expose
    val created: String?
)