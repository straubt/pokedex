package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val name: String,
    val url: String
)