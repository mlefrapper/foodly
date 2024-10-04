package com.mlefrapper.foodly.ui.screen.main.search

import com.mlefrapper.foodly.data.model.SearchResponseDto

sealed class SearchState {
    data object Idle : SearchState()
    data object Loading : SearchState()
    data class Success(val results: SearchResponseDto) : SearchState()
    data class Error(val message: String) : SearchState()
}
