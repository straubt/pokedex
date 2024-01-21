package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class Results (
    var name: String,
    var url: String,
    var imageUrl: String? = null
)