package com.amarinag.rickandmorty.extension

fun String?.checkBlankOrNull(): String? = if (!this.isNullOrBlank()) this else null