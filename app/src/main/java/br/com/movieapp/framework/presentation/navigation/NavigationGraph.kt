package br.com.movieapp.framework.presentation.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.movieapp.feature.moviepopular.presentation.MoviePopularScreen
import br.com.movieapp.feature.moviepopular.presentation.MoviePopularState
import br.com.movieapp.feature.moviepopular.presentation.MoviePopularViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.MoviePopular.route,
    ) {
        composable(route = BottomNavItem.MoviePopular.route) {

            val viewModel: MoviePopularViewModel = hiltViewModel()

            MoviePopularScreen(
                state = viewModel.uiState,
                navigateToDetailMovie = {}
            )
        }
        composable(route = BottomNavItem.MovieSearch.route) {
            Text(text = "Search")
        }
        composable(route = BottomNavItem.MovieFavorite.route) {
            Text(text = "Favorite")
        }
    }
}