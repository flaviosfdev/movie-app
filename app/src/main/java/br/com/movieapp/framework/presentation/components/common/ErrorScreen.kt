package br.com.movieapp.framework.presentation.components.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.movieapp.R
import br.com.movieapp.ui.theme.white

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    message: String,
    retry: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            color = white,
        )
        Button(
            onClick = retry
        ) {
            Text(text = stringResource(id = R.string.reload))
        }
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    ErrorScreen(
        message = "Error",
        retry = {},
    )
}