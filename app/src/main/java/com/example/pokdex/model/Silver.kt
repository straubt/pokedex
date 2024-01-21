package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Silver (
    @SerialName(value = "back_default")
    val backDefault: String? = null,
    @SerialName(value = "back_shiny")
    val backShiny: String? = null,
    @SerialName(value = "front_default")
    val frontDefault: String? = null,
    @SerialName(value = "front_shiny")
    val frontShiny: String? = null,
    @SerialName(value = "front_transparent")
    val frontTransparent: String? = null
)