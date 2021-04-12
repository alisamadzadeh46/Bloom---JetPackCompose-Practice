package com.example.bloom

import com.example.bloom.model.PlantTheme
import com.example.bloom.model.defaultPlantTheme
import com.example.bloom.model.homeGardenThemes
import com.example.bloom.repository.PlantRepository
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