package com.example.bloom


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bloom.ui.theme.BloomTheme

@Composable
fun HomeGardenListItem(plantTheme: PlantTheme) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        PlantImage(plantTheme)
        Column {
            TileDescriptionCheckboxRow(plantTheme)
            Divider()
        }

    }
}

@Composable
private fun TileDescriptionCheckboxRow(plantTheme: PlantTheme) {
    Row(
        verticalAlignment =
        Alignment.CenterVertically,
    ) {
        TitleAndDescription(plantTheme)
        PlantCheckbox()

    }

}

@Composable
private fun PlantCheckbox() {
    val checkedState = remember {
        mutableStateOf(false)
    }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { isChecked ->
            checkedState.value = isChecked
        },
        modifier = Modifier
            .size(24.dp)
    )
}

@Composable
private fun RowScope.TitleAndDescription(plantTheme: PlantTheme) {
    Column(
        modifier = Modifier
            .weight(1F)
    ) {
        Text(
            text = plantTheme.title,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)

        )
        Text(
            text = "This is a description",
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)


        )
    }
}


@Composable
private fun PlantImage(plantTheme: PlantTheme) {
    Image(
        painterResource(id = plantTheme.imageRes),
        contentDescription = "${plantTheme.title} Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(64.dp)
            .clip(MaterialTheme.shapes.small),
    )
}

@Preview
@Composable
private fun PreviewDarkItem() {
    BloomTheme(darkTheme = true) {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            HomeGardenListItem(homeGardenThemes.first())
        }


    }

}

@Preview
@Composable
private fun PreviewLightItem() {
    BloomTheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            HomeGardenListItem(homeGardenThemes.first())
        }


    }
}
