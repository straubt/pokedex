package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class GenerationII (
    val crystal: Crystal,
    val gold: Gold? = null,
    val silver: Silver? = null
)