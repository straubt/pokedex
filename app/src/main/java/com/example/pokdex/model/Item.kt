package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class Item (
    val name: String,
    val url: String
)