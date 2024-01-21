package com.example.pokdex.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.fragment.app.FragmentManager.BackStackEntry
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

sealed interface PokemonScreenUiState {
    data class Success(val pokemon: Pokemon) : PokemonScreenUiState
    object Error : PokemonScreenUiState
    object Loading : PokemonScreenUiState
}

class PokemonScreenViewModelHelper {
    var currentPokemonName: String = ""
}

// Créez une instance globale de la classe d'assistance
val pokemonViewModelHelper = PokemonScreenViewModelHelper()

class PokemonScreenViewModel(private val pokedexRepository: PokedexRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var pokemonScreenUiState: PokemonScreenUiState by mutableStateOf(PokemonScreenUiState.Loading)
        private set
    var pokemon: String = pokemonViewModelHelper.currentPokemonName
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getPokemon()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [Pokemon] [List] [MutableList].
     */
    fun getPokemon() {
        viewModelScope.launch {
            pokemonScreenUiState = PokemonScreenUiState.Loading
            pokemonScreenUiState = try {
                var pokemonResponse: Pokemon = pokedexRepository.getPokemonDetails(pokemon)
                PokemonScreenUiState.Success(pokemonResponse)
            } catch (e: IOException) {
                PokemonScreenUiState.Error
            } catch (e: HttpException) {
                PokemonScreenUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokedexApplication)
                val pokedexRepository = application.container.pokedexRepository
                PokemonScreenViewModel(pokedexRepository = pokedexRepository)
            }
        }
    }
}
