package br.com.movieapp.feature.moviepopular.data.source

import br.com.movieapp.feature.moviepopular.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.framework.data.remote.MovieService
import br.com.movieapp.framework.data.remote.response.MovieResponse
import br.com.movieapp.framework.pagging.MoviePagingSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService,
) : MoviePopularRemoteDataSource {
    override fun getPopularMoviesPagingSource(): MoviePagingSource = MoviePagingSource(this)

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page = page)
    }
}