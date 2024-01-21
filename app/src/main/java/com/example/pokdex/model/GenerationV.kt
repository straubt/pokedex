package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationV (
    @SerialName(value = "black-white")
    val blackWhite: BlackWhite? = null
)