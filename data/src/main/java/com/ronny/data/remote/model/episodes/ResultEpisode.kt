package com.ronny.data.remote.model.episodes

import kotlinx.serialization.Serializable

@Serializable
data class ResultEpisode(
    val air_date: String,
    val characters: List<Any>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)