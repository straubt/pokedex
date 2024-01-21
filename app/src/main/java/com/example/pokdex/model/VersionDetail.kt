package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class VersionDetail (
    val rarity: Int,
    val version: Version
)