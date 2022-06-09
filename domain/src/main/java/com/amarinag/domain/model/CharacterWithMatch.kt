package com.amarinag.domain.model

data class CharacterWithMatch(
    val character: Character,
    val match: Character? = null,
    val throwable: Throwable? = null
)