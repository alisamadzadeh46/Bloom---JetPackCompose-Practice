package com.example.bloom

data class HomeViewState(
    val plantTheme: List<PlantTheme> = emptyList(),
    val homeGardenItems: List<PlantTheme> = emptyList(),
) {
    val showLoading: Boolean
        get() = plantTheme.isEmpty() || homeGardenItems.isEmpty()
}
