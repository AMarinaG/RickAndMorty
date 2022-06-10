package com.amarinag.domain.model

data class Match(
    val character: Character,
    val match: Character? = null,
    val matchLocation: String? = null,
    val sharedEpisodeCount: Int? = null,
    val sharedEpisodesList: List<String>? = null,
    val metDate: String? = null,
    val lastMetDate: String? = null,
    val throwable: Throwable? = null
)