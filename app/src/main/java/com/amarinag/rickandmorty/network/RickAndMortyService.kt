package com.amarinag.rickandmorty.network

import com.amarinag.rickandmorty.network.model.RemoteCharacter
import com.amarinag.rickandmorty.network.model.RemoteResponse
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("character")
    suspend fun getCharacters(): RemoteResponse<List<RemoteCharacter>>
}