package com.ronny.data.remote.model.characters

import com.ronny.data.remote.model.Info
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    val info: Info,
    val results: List<ResultCharacters>
)