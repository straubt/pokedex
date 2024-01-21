package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIII (
    val emerald: Emerald? = null,
    @SerialName(value = "firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen? = null,
    @SerialName(value = "ruby-sapphire")
    val rubySapphire: RubySapphire? = null
)