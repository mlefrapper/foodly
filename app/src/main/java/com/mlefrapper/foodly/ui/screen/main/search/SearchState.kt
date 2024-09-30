package com.mlefrapper.foodly.ui.screen.main.search

sealed class SearchState {
    data object Idle : SearchState()
    data object Loading : SearchState()
    data class Success(val results: List<String>) : SearchState()
    data class Error(val message: String) : SearchState()
}
