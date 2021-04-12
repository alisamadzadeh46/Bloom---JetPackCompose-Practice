package com.example.bloom

import kotlinx.coroutines.delay

class InMemoryPlantServices : PlantRepository {
    override suspend fun fetchThemes(): List<PlantTheme> {
        delay(5000)
        return defaultPlantTheme
    }

    override suspend fun fetchHomeGardenItems(): List<PlantTheme> {
        return homeGardenThemes
    }
}