package com.example.bloom.viewmodel

import com.example.bloom.model.PlantTheme

data class HomeViewState(
    val plantTheme: List<PlantTheme> = emptyList(),
    val homeGardenItems: List<PlantTheme> = emptyList(),
) {
    val showLoading: Boolean
        get() = plantTheme.isEmpty() || homeGardenItems.isEmpty()
}
