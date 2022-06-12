package com.amarinag.rickandmorty.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amarinag.domain.model.Character

@Entity(tableName = "character")
data class LocalCharacter(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "species")
    val species: String?,
    @ColumnInfo(name = "type")
    val type: String?,
    @ColumnInfo(name = "image_url")
    val imageUrl: String?,
    @ColumnInfo(name = "location_name")
    val locationName: String?,
    @ColumnInfo(name = "location_url")
    val locationUrl: String?,
    @ColumnInfo(name = "episode")
    val episode: List<String>?
)


fun LocalCharacter.toDomain(): Character = Character(
    id = id,
    name = name,
    species = species,
    type = type,
    imageUrl = imageUrl,
    locationName = locationName,
    locationUrl = locationUrl,
    episode = episode
)

fun List<LocalCharacter>.toDomain(): List<Character> = map { it.toDomain() }

fun Character.toEntity(): LocalCharacter =
    LocalCharacter(id, name, species, species, type, locationName, locationUrl, episode)

fun List<Character>.toEntity(): List<LocalCharacter> = map { it.toEntity() }