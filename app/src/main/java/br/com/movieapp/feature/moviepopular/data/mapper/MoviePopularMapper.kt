package br.com.movieapp.feature.moviepopular.data.mapper

import br.com.movieapp.framework.data.remote.model.MovieResult
import br.com.movieapp.framework.domain.model.Movie
import br.com.movieapp.framework.util.toPostUrl

fun List<MovieResult>.toMovie() = map { movieResult ->
    Movie(
        id = movieResult.id,
        title = movieResult.title,
        voteAverage = movieResult.voteAverage,
        imageUrl = movieResult.posterPath.toPostUrl()
    )
}