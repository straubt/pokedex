package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Abilities (
    val ability: Ability,
    @SerialName(value = "is_hidden")
    val isHidden: Boolean,
    val slot: Int,
)