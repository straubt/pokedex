package com.example.pokdex.model

import kotlinx.serialization.Serializable
import java.io.Serial

@Serializable
data class Form(
    val name: String,
    val url: String,
)