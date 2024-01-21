package com.example.pokdex.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavBackStackEntry
import coil.network.HttpException
import com.example.pokdex.PokedexApplication
import com.example.pokdex.data.PokedexRepository
import com.example.pokdex.model.AllPokemons
import com.example.pokdex.model.Pokemon
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface PokemonUiState {
    data class Success(val pokemons: AllPokemons) : PokemonUiState
    object Error : PokemonUiState
    object Loading : PokemonUiState
}

class PokemonViewModel(private val pokedexRepository: PokedexRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var pokemonUiState: PokemonUiState by mutableStateOf(PokemonUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getPokemons()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [Pokemon] [List] [MutableList].
     */
    fun getPokemons() {
        viewModelScope.launch {
            pokemonUiState = PokemonUiState.Loading
            pokemonUiState = try {
                var pokemonListResponse: AllPokemons = pokedexRepository.getPokemons()
                for (i in 0 until pokemonListResponse.results.size){
                    val pokemon = pokemonListResponse.results[i]
                    try{
                        val detailResponse = pokedexRepository.getPokemonDetails(pokemonListResponse.results[i].name)
                        pokemonListResponse.results[i].imageUrl = detailResponse.sprites.frontDefault
                    }catch (e: Exception) {
                        Log.e("PokemonDetailsError", "Error for Pokemon at index $i: ${pokemon.name}", e)
                    }
                }
                PokemonUiState.Success(pokemonListResponse)
            } catch (e: IOException) {
                PokemonUiState.Error
            } catch (e: HttpException) {
                PokemonUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokedexApplication)
                val pokedexRepository = application.container.pokedexRepository
                PokemonViewModel(pokedexRepository = pokedexRepository)
            }
        }
    }
}

