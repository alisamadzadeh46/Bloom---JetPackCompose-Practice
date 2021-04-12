package com.example.bloom

data class HomeViewState(
    val plantTheme: List<PlantTheme> = emptyList(),
    val homeGardenItems: List<PlantTheme> = emptyList(),
)
