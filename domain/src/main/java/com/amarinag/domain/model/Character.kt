package com.amarinag.domain.model

data class Character(
    val id: Int,
    val name: String,
    val species: String?,
    val type: String?,
    val imageUrl: String?,
    val locationName: String?,
    val locationUrl: String?,
    val episode: List<String>?
)