package br.com.movieapp.feature.moviepopular.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.com.movieapp.R
import br.com.movieapp.framework.domain.model.Movie
import br.com.movieapp.framework.presentation.components.common.ErrorScreen
import br.com.movieapp.framework.presentation.components.common.LoadingComponent
import br.com.movieapp.ui.theme.black

@Composable
fun MovieContent(
    pagingMovies: LazyPagingItems<Movie>,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    onClick: (movieId: Int) -> Unit,
) {
    Box(
        modifier = modifier.background(black)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(paddingValues).fillMaxSize()
        ) {
            items(pagingMovies.itemCount) {index ->
                val movie = pagingMovies[index]
                movie?.let { safeMovie ->
                    MovieItem(movie = safeMovie) { movieId ->
                        onClick(movieId)
                    }
                }
            }
            pagingMovies.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingComponent()
                        }
                    }
                    loadState.append is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingComponent()
                        }
                    }
                    loadState.refresh is LoadState.Error -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(
                                message = stringResource(id = R.string.networkErrorMessage),
                                retry = { retry() }
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(
                                message = stringResource(id = R.string.networkErrorMessage),
                                retry = { retry() }
                            )
                        }
                    }
                }
            }
        }
    }
}