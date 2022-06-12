package com.amarinag.rickandmorty.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
