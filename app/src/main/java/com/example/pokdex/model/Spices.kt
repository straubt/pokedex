package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class Spices (
    val name: String,
    val url: String
)