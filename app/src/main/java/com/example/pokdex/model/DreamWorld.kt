package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DreamWorld (
    @SerialName(value = "front_default")
    val frontDefault: String? = null,
    @SerialName(value = "front_female")
    val frontFemale: String? = null
)