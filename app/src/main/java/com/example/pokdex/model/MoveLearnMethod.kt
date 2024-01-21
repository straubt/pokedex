package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class MoveLearnMethod (
    val name : String,
    val url: String
)