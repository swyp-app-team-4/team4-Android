package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PlaceListDTO (
    val places: List<Place>
)