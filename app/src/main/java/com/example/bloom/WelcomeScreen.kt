package com.example.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bloom.ui.theme.BloomTheme

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    )
    {
        val isLight = MaterialTheme.colors.isLight
        val backgroundImageRes = if (isLight) {
            R.drawable.ic_light_welcome_bg
        } else {
            R.drawable.ic_dark_welcome_bg
        }
        Image(painterResource(id = backgroundImageRes),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
private fun PreviewDarkWelcomeScreen() {
    BloomTheme(darkTheme = true) {
        WelcomeScreen()
    }
}

@Preview
@Composable
private fun PreviewLightWelcomeScreen() {
    BloomTheme(darkTheme = false) {
        WelcomeScreen()
    }
}
