package com.ronny.data.remote.model.locations

import com.ronny.data.remote.model.Info
import kotlinx.serialization.Serializable

@Serializable
class LocationResponse(
    val info: Info,
    val results: List<ResultLocations>
)