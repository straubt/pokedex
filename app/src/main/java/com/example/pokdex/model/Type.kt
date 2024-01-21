package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class Type (
    val name: String,
    val url: String
)