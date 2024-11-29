package com.mlefrapper.foodly.ui.screen.main.search

import kotlinx.coroutines.flow.MutableStateFlow

interface ISearchViewModel {
    val searchState: MutableStateFlow<SearchState>

    fun search(query: String)
}
