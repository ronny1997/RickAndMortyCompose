package com.ronny.data.remote.model.episodes

import com.ronny.data.remote.model.Info
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    val info: Info,
    val results: List<ResultEpisode>
)