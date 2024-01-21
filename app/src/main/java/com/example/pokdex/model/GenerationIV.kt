package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIV (
    @SerialName(value = "diamond-pearl")
    val diamondPearl: DiamondPearl? = null,
    @SerialName(value = "heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver? = null,
    val platinium: Platinium? = null
)