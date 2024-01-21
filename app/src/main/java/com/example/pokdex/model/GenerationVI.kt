package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVI (
    @SerialName(value = "omegaruby-alphasapphire")
    val omegarubyAlphaSapphire: OmegarubyAlphasapphire? = null,
    @SerialName(value = "x-y")
    val xy: XY? = null
)