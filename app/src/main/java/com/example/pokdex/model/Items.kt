package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Items (
    val item: Item,
    @SerialName(value = "version_details")
    val versionDetails: List<VersionDetail>
)