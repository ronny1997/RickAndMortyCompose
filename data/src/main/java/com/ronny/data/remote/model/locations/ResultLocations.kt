package com.ronny.data.remote.model.locations


import kotlinx.serialization.Serializable

@Serializable
data class ResultLocations(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)