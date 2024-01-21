package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class Version (
    val name: String,
    val url: String
)