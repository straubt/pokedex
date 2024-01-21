package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Moves (
    var move: Move,
    @SerialName(value = "version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)