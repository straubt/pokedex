package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Other (
    @SerialName(value = "dream_world")
    val dreamWorld: DreamWorld,
    val home: Home,
    @SerialName(value = "official-artwork")
    val officialArtwork: OfficialArtwork,
    val showdown: ShowDown
)