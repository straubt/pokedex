@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pokdex.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokdex.R
import com.example.pokdex.ui.screens.HomeScreen
import com.example.pokdex.ui.screens.PokemonScreen
import com.example.pokdex.ui.screens.PokemonScreenViewModel
import com.example.pokdex.ui.screens.PokemonUiState
import com.example.pokdex.ui.screens.PokemonViewModel
import com.example.pokdex.ui.screens.pokemonViewModelHelper

enum class PokedexScreen(@StringRes val title: Int){
    Home(title = R.string.home),
    Pokemon(title = R.string.pokemon)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexApp() {
    val pokemonViewModel: PokemonViewModel = viewModel(factory = PokemonViewModel.Factory)
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    var currentScreen = backStackEntry?.destination?.route ?: PokedexScreen.Home.name
    if(currentScreen == PokedexScreen.Home.name) {
        currentScreen = stringResource(R.string.app_name)
    }
    Scaffold(

        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PokedexTopAppBar(
                scrollBehavior = scrollBehavior,
                navController = navController,
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Navigation(
                pokemonUiState = pokemonViewModel.pokemonUiState,
                navController = navController,
                destination = PokedexScreen.Home.name
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    canNavigateBack: Boolean,
    currentScreen: String
) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = currentScreen,
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun Navigation(
    pokemonUiState: PokemonUiState,
    navController: NavHostController,
    destination: String
) {
    NavHost(
        navController = navController,
        startDestination = destination
    ) {
        composable(PokedexScreen.Home.name) {
            HomeScreen(
                pokemonUiState = pokemonUiState,
                retryAction = {},
                navController = navController,
            )
        }
        composable(
            route = PokedexScreen.Pokemon.name + "/{pokemonId}",
            arguments = listOf(navArgument("pokemonId") { type = NavType.StringType })
        ) {backStackEntry ->
            backStackEntry.arguments?.getString("pokemonId")?.let {
                pokemonViewModelHelper.currentPokemonName = it
                val pokemonScreenViewModel: PokemonScreenViewModel = viewModel(factory = PokemonScreenViewModel.Factory)
                PokemonScreen(
                    modifier = Modifier,
                    pokemonScreenUiState = pokemonScreenViewModel.pokemonScreenUiState
                )
            }
        }
    }
}