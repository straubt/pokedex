package com.example.pokdex.network

import com.example.pokdex.model.AllPokemons
import com.example.pokdex.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexAPIService {

    @GET("pokemon?limit=19")
    suspend fun getPokemons(): AllPokemons

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): Pokemon
}