package br.com.movieapp.feature.moviepopular.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import br.com.movieapp.R
import br.com.movieapp.framework.domain.model.Movie
import br.com.movieapp.ui.theme.black
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    onClick: (id: Int) -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        MovieRate(
            rate = movie.voteAverage,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .zIndex(2f)
                .padding(8.dp)
                .background(
                    color = black,
                    shape = RoundedCornerShape(75.dp)
                )
        )
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .padding(4.dp)
                .clickable { onClick(movie.id) },
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp
        ) {
            Box {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.imageUrl)
                        .crossfade(true)
                        .error(R.drawable.ic_error_image)
                        .placeholder(R.drawable.ic_placeholder)
                        .build(),
                    contentDescription = "Movie Post",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview
@Composable
private fun MovieItemPreview() {
    MovieItem(
        movie = Movie(
            id = 1,
            title = "Title",
            voteAverage = 8.1,
            imageUrl = ""
        ),
        onClick = {}
    )
}