package br.com.movieapp.feature.moviepopular.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.movieapp.ui.theme.black
import br.com.movieapp.ui.theme.white
import br.com.movieapp.ui.theme.yellow

@Composable
fun MovieRate(
    rate: Double,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .widthIn(max = 75.dp)
            .padding(vertical = 4.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.StarRate,
            tint = yellow,
            contentDescription = "Movie rate",
            modifier = Modifier.size(12.dp)
        )
        Text(
            text = rate.toString(),
            color = white,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
private fun MovieRatePreview() {
    Column {
        MovieRate(rate = 7.0)
        Spacer(modifier = Modifier.padding(vertical = 2.dp))
        MovieRate(rate = 10.0)
    }
}