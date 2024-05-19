package br.com.movieapp.feature.moviepopular.domain.source

import br.com.movieapp.framework.data.remote.response.MovieResponse
import br.com.movieapp.framework.pagging.MoviePagingSource

interface MoviePopularRemoteDataSource {

    fun getPopularMoviesPagingSource() : MoviePagingSource

    suspend fun getPopularMovies(page: Int): MovieResponse

}