package com.ronny.data.remote.model.characters

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String,
    val url: String
)