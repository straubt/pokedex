package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class Types (
    val slot: Int,
    val type: Type
)