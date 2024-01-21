package com.example.pokdex.data

import com.example.pokdex.model.AllPokemons
import com.example.pokdex.model.Pokemon
import com.example.pokdex.network.PokedexAPIService

interface PokedexRepository {
    suspend fun getPokemons(): AllPokemons
    suspend fun getPokemonDetails(name: String): Pokemon
}

class NetworkPokedexRepository(
private val pokedexApiService: PokedexAPIService
) : PokedexRepository {
    /** Fetches list of MarsPhoto from marsApi*/
    override suspend fun getPokemons(): AllPokemons = pokedexApiService.getPokemons()
    override suspend fun getPokemonDetails(name: String): Pokemon = pokedexApiService.getPokemonDetails(name)
}