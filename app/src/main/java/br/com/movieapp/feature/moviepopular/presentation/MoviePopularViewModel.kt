package br.com.movieapp.feature.moviepopular.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.movieapp.feature.moviepopular.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    getPopularMoviesUseCase: GetPopularMoviesUseCase,
) : ViewModel() {

    var uiState by mutableStateOf(MoviePopularState())
        private set

    init {
        val movies = getPopularMoviesUseCase.invoke()
            .cachedIn(viewModelScope)
        uiState = uiState.copy(movies = movies)
    }

}