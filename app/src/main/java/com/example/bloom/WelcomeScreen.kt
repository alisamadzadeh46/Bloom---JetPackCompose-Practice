package com.example.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bloom.ui.theme.BloomTheme

@Composable
fun WelcomeScreen() {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()

    )
    {
        WelcomeBackground()
        WelcomeScreenContent()
    }
}

@Composable
private fun WelcomeScreenContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(72.dp))
        LeafImage()
        Spacer(modifier = Modifier.height(48.dp))
        LogoImage()
        AppSubtitle()
        Spacer(modifier = Modifier.height(48.dp))
        CreateAccountButton()
        Spacer(modifier = Modifier.height(8.dp))
        LoginButton()
    }
}

@Composable
private fun LeafImage() {
    val isLight = MaterialTheme.colors.isLight
    val leafImageRes = if (isLight) {
        R.drawable.ic_light_welcome_illos
    } else {
        R.drawable.ic_dark_welcome_illos
    }
    Image(
        painter = painterResource(id = leafImageRes),
        contentDescription = null,
        modifier = Modifier
            .offset(x = 88.dp)
    )
}


@Composable
private fun LogoImage() {
    val isLight = MaterialTheme.colors.isLight
    val logoImageRes = if (isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }
    Image(
        painter = painterResource(id = logoImageRes),
        contentDescription = "Bloom",
    )
}


@Composable
private fun AppSubtitle() {
    Text(
        text = "Beautiful home garden solutions",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
    )
}

@Composable
private fun CreateAccountButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text("Create account")
    }
}

@Composable
private fun LoginButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text("Log in")
    }
}

@Composable
private fun WelcomeBackground() {
    val isLight = MaterialTheme.colors.isLight
    val backgroundImageRes = if (isLight) {
        R.drawable.ic_light_welcome_bg
    } else {
        R.drawable.ic_dark_welcome_bg
    }
    Image(
        painterResource(id = backgroundImageRes),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
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
