package com.example.bloom

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bloom.ui.theme.BloomTheme

@Composable
fun LoginScreen() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LogInHeader()
            EmailInput()
            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
            PasswordInput()

            TermsOfServiceLabel()
        }

    }
}

@Composable
private fun TermsOfServiceLabel() {
    Text(
        text = "By clicking below you agree to our Terms of Use and consent to our Privacy Policy.",
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .paddingFromBaseline(
                top = 24.dp,
            )
    )
}

@Composable
private fun PasswordInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Password (8+ characters)") },
        modifier = Modifier
            .fillMaxWidth(),
    )
}


@Composable
private fun EmailInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Email address") },
        modifier = Modifier
            .fillMaxWidth(),

        )
}


@Composable
private fun LogInHeader() {
    Text(
        text = "Log in with email",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(
                top = 184.dp,
                bottom = 16.dp
            )
    )
}


@Preview
@Composable
private fun PreviewDarkLogin() {
    BloomTheme(darkTheme = true) {
        LoginScreen()
    }
}

@Preview
@Composable
private fun PreviewLightLogin() {
    BloomTheme(darkTheme = false) {
        LoginScreen()
    }
}