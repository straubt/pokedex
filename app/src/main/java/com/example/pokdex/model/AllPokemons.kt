package com.example.pokdex.model

import kotlinx.serialization.Serializable

@Serializable
data class AllPokemons (
    var count: Int,
    var next: String? = null,
    var previous: String? = null,
    var results: List<Results>
)