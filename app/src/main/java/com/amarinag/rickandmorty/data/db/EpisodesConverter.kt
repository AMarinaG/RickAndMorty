package com.amarinag.rickandmorty.data.db

import androidx.room.TypeConverter

class EpisodesConverter {
    @TypeConverter
    fun fromListEpisodes(value: List<String>?): String? {
        return value?.joinToString()
    }

    @TypeConverter
    fun toLisEpisodes(episodes: String?): List<String>? {
        return episodes?.split(",")
    }
}