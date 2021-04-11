package com.example.bloom

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bloom.ui.theme.BloomTheme

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BloomBottomBar()
        }
    ) {
        HomeScreenContent()
    }

}

@Composable
private fun BloomBottomBar() {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        BloomBottomButton(
            selected = true,
            icon = Icons.Default.Home,
            labelText = "Home"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.FavoriteBorder,
            labelText = "Favorites"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.AccountCircle,
            labelText = "Profile"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.ShoppingCart,
            labelText = "Cart"
        )
    }
}

@Composable
private fun BloomBottomButton(
    selected: Boolean,
    icon: ImageVector,
    labelText: String,
) {
    BottomAppBar {
        BottomNavigationItem(
            selected = selected,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    icon,
                    contentDescription = null,
                )
            },
            label = {
                Text(labelText)
            }
        )


    }
}

@Composable
private fun HomeScreenContent() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),

            )
        {
            Spacer(modifier = Modifier.height(40.dp))
            SearchInput()
            BroseThemesSection()
            HomeGardenSection()

        }
    }
}

@Composable
private fun HomeGardenSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Design your home garden",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
                .weight(1F)

        )
        Icon(
            Icons.Default.List,
            contentDescription = "Filter",
            modifier = Modifier
                .size(24.dp)


        )
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp),
    ) {
        homeGardenThemes.forEach { theme ->
            HomeGardenListItem(theme)
        }
    }
}

@Composable
private fun BroseThemesSection() {
    Text(
        text = "Browse themes",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
            .padding(horizontal = 16.dp),
    )
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
    ) {
        defaultPlantTheme.forEach { theme ->
            PlantThemeCard(theme)
        }
    }
}


@Composable
private fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text("Search")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .size(18.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
    )
}


@Preview
@Composable
private fun PreviewDarkHome() {
    BloomTheme(darkTheme = true) {
        HomeScreen()

    }
}

@Preview
@Composable
private fun PreviewLightHome() {
    BloomTheme(darkTheme = false) {
        HomeScreen()

    }
}