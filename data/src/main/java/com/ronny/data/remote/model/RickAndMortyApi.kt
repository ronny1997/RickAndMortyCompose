package com.ronny.data.remote.model

import com.ronny.data.remote.model.characters.CharactersResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

data class RickAndMortyApi @Inject constructor(val client: HttpClient) {

    suspend fun getCharacters(): CharactersResponse = client.get("")

}