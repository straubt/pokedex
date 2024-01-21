package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameIndice (
    @SerialName(value = "game_index")
    val gameIndex: Int,
    val version: Version
)