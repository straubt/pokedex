package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVII (
    val icons: Icons? = null,
    @SerialName(value = "ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon? = null
)