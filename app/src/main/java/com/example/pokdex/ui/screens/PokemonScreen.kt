package com.example.pokdex.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokdex.R
import com.example.pokdex.model.Pokemon

@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    pokemonScreenUiState: PokemonScreenUiState
){
    when(pokemonScreenUiState){
        is PokemonScreenUiState.Loading -> LoadingScreenPokemon(modifier = modifier.fillMaxSize())
        is PokemonScreenUiState.Error -> ErrorScreenPokemon(modifier = modifier.fillMaxSize())
        is PokemonScreenUiState.Success -> PokemonInfo(pokemonScreenUiState.pokemon, modifier)
    }
}

@Composable
fun PokemonInfo(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
){
    Text(text = pokemon.name)
}

@Composable
fun LoadingScreenPokemon(
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreenPokemon(
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
    )
}