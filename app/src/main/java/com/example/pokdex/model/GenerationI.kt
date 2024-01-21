package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationI (
    @SerialName(value = "red-blue")
    val redBlue: RedBlue? = null,
    val yellow: Yellow? = null
)