package br.com.movieapp.feature.moviepopular.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.feature.moviepopular.domain.repository.MoviePopularRepository
import br.com.movieapp.feature.moviepopular.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.framework.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MoviePopularRepositoryImpl constructor(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : MoviePopularRepository {
    override fun getPopularMovies(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { remoteDataSource.getPopularMoviesPagingSource() }
        ).flow
    }
}