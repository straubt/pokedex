package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stats (
    @SerialName(value = "base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: Stat
)