package br.com.movieapp.feature.moviepopular.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.feature.moviepopular.domain.repository.MoviePopularRepository
import br.com.movieapp.framework.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPopularMoviesUseCase {
    operator fun invoke(): Flow<PagingData<Movie>>
}

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MoviePopularRepository,
) : GetPopularMoviesUseCase {
    override fun invoke(): Flow<PagingData<Movie>> {
        return repository.getPopularMovies(
            PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
            )
        )
    }
}