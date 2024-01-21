package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class VersionGroup (
    val name: String,
    val url: String
)
