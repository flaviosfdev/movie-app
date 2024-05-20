package br.com.movieapp.feature.moviepopular.presentation

import androidx.paging.PagingData
import br.com.movieapp.framework.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MoviePopularState(
    val movies: Flow<PagingData<Movie>> = emptyFlow()
)
