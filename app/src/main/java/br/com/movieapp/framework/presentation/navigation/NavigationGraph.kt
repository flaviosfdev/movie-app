package br.com.movieapp.framework.presentation.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.MoviePopular.route,
    ) {
        composable(route = BottomNavItem.MoviePopular.route) {
            Text(text = "Popular")
        }
        composable(route = BottomNavItem.MovieSearch.route) {
            Text(text = "Search")
        }
        composable(route = BottomNavItem.MovieFavorite.route) {
            Text(text = "Favorite")
        }
    }
}