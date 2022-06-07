package com.amarinag.rickandmorty.data.network

import com.amarinag.rickandmorty.data.network.model.RemoteCharacter
import com.amarinag.rickandmorty.data.network.model.RemoteResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {
    @GET("character")
    suspend fun getCharacters(): RemoteResponse<List<RemoteCharacter>>

    @GET("character/{characterId}")
    suspend fun getCharactersById(@Path("characterId") characterId: Int): RemoteResponse<RemoteCharacter>
}