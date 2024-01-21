package com.example.pokdex.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokdex.R
import com.example.pokdex.model.AllPokemons
import com.example.pokdex.model.Pokemon
import com.example.pokdex.model.Results
import com.example.pokdex.ui.PokedexScreen
import com.example.pokdex.ui.theme.PokédexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCard(
    pokemon: Results,
    navController: NavController,
    modifier: Modifier = Modifier,
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        onClick = {navController.navigate(PokedexScreen.Pokemon.name + "/" + pokemon.name)}
    ){
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(pokemon.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = pokemon.name,
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PokemonGridScreen(
    pokemons: AllPokemons,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = pokemons.results,
            key = { pokemon -> pokemon.name }
        ) {
                pokemon -> PokemonCard(
                    pokemon,
                    modifier = modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .aspectRatio(1.5f),
                    navController = navController
                )
        }
    }
}

@Composable
fun HomeScreen(
    pokemonUiState: PokemonUiState,
    navController: NavController,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (pokemonUiState) {
        is PokemonUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is PokemonUiState.Success -> PokemonGridScreen(pokemonUiState.pokemons, navController, modifier)
        else -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}

@Composable
fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = photos)
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    PokédexTheme {
        LoadingScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    PokédexTheme {
        ErrorScreen({})
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    PokédexTheme {
        val mockData = List(10) { Pokemon("$it", "") }
        PokemonGridScreen(mockData)
    }
}
*/