package br.com.movieapp.feature.moviepopular.presentation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.movieapp.R
import br.com.movieapp.feature.moviepopular.presentation.components.MovieContent
import br.com.movieapp.framework.presentation.navigation.BottomNavigationBar
import br.com.movieapp.framework.util.UtilFunctions
import br.com.movieapp.ui.theme.black
import br.com.movieapp.ui.theme.white

@Composable
fun MoviePopularScreen(
    state: MoviePopularState,
    navigateToDetailMovie: (movieId: Int) -> Unit,
) {
    val movies = state.movies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.popular_movies),
                        color = white,
                    )
                },
                backgroundColor = black
            )
        },
        content = { paddingValues ->
            MovieContent(
                pagingMovies = movies,
                paddingValues = paddingValues,
                onClick = { movieId ->
                    UtilFunctions.logInfo("MOVIE_ID", movieId.toString())
                    navigateToDetailMovie(movieId)
                }
            )
        }
    )
}