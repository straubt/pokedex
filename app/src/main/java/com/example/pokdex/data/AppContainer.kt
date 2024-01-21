package com.example.pokdex.data

import com.example.pokdex.network.PokedexAPIService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface AppContainer {
    val pokedexRepository: PokedexRepository
}

class DefaultAppContainer: AppContainer {
    private val baseUrl = "https://pokeapi.co/api/v2/"

    val myJson = Json{
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(myJson.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: PokedexAPIService by lazy {
        retrofit.create(PokedexAPIService::class.java)
    }
    /**
     * DI implementation for Mars photos repository
     */
    override val pokedexRepository: PokedexRepository by lazy {
        NetworkPokedexRepository(retrofitService)
    }
}