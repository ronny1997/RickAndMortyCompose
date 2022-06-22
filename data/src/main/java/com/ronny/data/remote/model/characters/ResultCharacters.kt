package com.ronny.data.remote.model.characters

import kotlinx.serialization.Serializable

@Serializable
data class ResultCharacters(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Location,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)