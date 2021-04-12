package com.example.bloom

class InMemoryPlantServices : PlantRepository {
    override suspend fun fetchThemes(): List<PlantTheme> {
        return defaultPlantTheme
    }

    override suspend fun fetchHomeGardenItems(): List<PlantTheme> {
        return homeGardenThemes
    }
}