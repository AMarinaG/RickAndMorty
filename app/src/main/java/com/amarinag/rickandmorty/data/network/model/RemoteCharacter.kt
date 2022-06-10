package com.amarinag.rickandmorty.data.network.model


import com.amarinag.domain.model.Character
import com.amarinag.rickandmorty.extension.checkBlankOrNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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

fun RemoteCharacter.toDomain(): Character = Character(
    id = id!!,
    name = name!!,
    species = species.checkBlankOrNull(),
    type = type.checkBlankOrNull(),
    imageUrl = image,
    locationName = location?.name.checkBlankOrNull(),
    locationUrl = location?.url.checkBlankOrNull(),
    episode = episode
)

fun List<RemoteCharacter>.toDomain(): List<Character> = map { it.toDomain() }

fun Character.toRemote(): RemoteCharacter =
    RemoteCharacter(id, name, null, species, type, null, null, null, null, null, null, null)

fun List<Character>.toRemote(): List<RemoteCharacter> = map { it.toRemote() }