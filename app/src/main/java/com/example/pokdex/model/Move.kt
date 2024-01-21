package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class Move (
    var name: String,
    var url: String
)