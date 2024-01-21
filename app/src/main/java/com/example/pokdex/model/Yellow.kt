package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Yellow (
    @SerialName(value = "back_default")
    val backDefault: String? = null,
    @SerialName(value = "back_gray")
    val backGray: String? = null,
    @SerialName(value = "back_transparent")
    val backTransparent: String? = null,
    @SerialName(value = "front_default")
    val frontDefault: String? = null,
    @SerialName(value = "front_gray")
    val frontGray: String? = null,
    @SerialName(value = "front_transparent")
    val frontTransparent: String? = null
)