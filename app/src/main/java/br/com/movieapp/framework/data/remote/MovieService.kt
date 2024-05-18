package br.com.movieapp.framework.data.remote

import br.com.movieapp.framework.data.remote.response.MovieDetailsResponse
import br.com.movieapp.framework.data.remote.response.MovieResponse
import br.com.movieapp.framework.data.remote.response.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
    ): MovieResponse

    @GET("search/multi")
    suspend fun searchMovie(
        @Query("page") page: Int,
        @Query("query") query: String,
    ): MovieSearchResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
    ): MovieDetailsResponse

    @GET("movie/{movie_id}/similar")
    suspend fun getMoviesSimilar(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int,
    ): MovieResponse
}