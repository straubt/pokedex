package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Versions (
    @SerialName(value = "generation-i")
    val generationI: GenerationI,
    @SerialName(value = "generation-ii")
    val generationII: GenerationII,
    @SerialName(value = "generation-iii")
    val generationIII: GenerationIII,
    @SerialName(value = "generation-iv")
    val generationIV: GenerationIV,
    @SerialName(value = "generation-v")
    val generationV: GenerationV,
    @SerialName(value = "generation-vi")
    val generationVI: GenerationVI,
    @SerialName(value = "generation-vii")
    val generationVII: GenerationVII,
    @SerialName(value = "generation-viii")
    val generationVIII: GenerationVIII,
    )