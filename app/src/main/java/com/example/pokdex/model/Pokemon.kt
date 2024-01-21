package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val abilities: List<Abilities>,
    val forms: List<Form>,
    @SerialName(value = "game_indices")
    val gameIndice: List<GameIndice>,
    @SerialName(value = "held_items")
    val heldHitem: List<Items>,
    val id: Int,
    @SerialName(value = "is_default")
    val isDefault: Boolean,
    @SerialName(value = "location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<Moves>,
    val name: String,
    val order: Int,
    val species: Spices,
    val sprites: Sprites,
    val stats: List<Stats>,
    val types: List<Types>,
    val weight: Int
)