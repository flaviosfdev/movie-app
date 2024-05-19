package br.com.movieapp.framework.presentation.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.movieapp.ui.theme.black
import br.com.movieapp.ui.theme.white
import br.com.movieapp.ui.theme.yellow

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {
    val items = listOf(
        BottomNavItem.MoviePopular,
        BottomNavItem.MovieSearch,
        BottomNavItem.MovieFavorite,
    )

    BottomNavigation(
        contentColor = yellow,
        backgroundColor = black,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { destination ->
            val selectedColor = if (currentRoute == destination.route) white else yellow
            BottomNavigationItem(
                selected = currentRoute == destination.route,
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.title,
                        tint = selectedColor
                    )
                },
                label = { Text(text = destination.title, color = selectedColor) },
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}