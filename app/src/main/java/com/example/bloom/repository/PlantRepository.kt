package com.example.bloom.repository

import com.example.bloom.model.PlantTheme


interface PlantRepository {
    suspend fun fetchThemes():List<PlantTheme>
    suspend fun fetchHomeGardenItems():List<PlantTheme>
}