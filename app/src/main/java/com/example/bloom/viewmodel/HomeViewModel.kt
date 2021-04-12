package com.example.bloom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloom.repository.PlantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val plantRepository:
    PlantRepository
) : ViewModel() {
    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState: StateFlow<HomeViewState> = _viewState

    init {
        fetchPlantThemes()
        fetchHomeGardenItems()
    }

    private fun fetchPlantThemes() {
        viewModelScope.launch {
            val plantTheme = plantRepository.fetchThemes()
            _viewState.value = _viewState.value.copy(
                plantTheme = plantTheme
            )
        }
    }

    private fun fetchHomeGardenItems() {
        viewModelScope.launch {
            val homeGardenItems = plantRepository.fetchHomeGardenItems()
            _viewState.value = _viewState.value.copy(
                homeGardenItems = homeGardenItems
            )
        }
    }
}