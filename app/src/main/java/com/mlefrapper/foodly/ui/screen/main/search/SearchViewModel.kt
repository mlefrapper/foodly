package com.mlefrapper.foodly.ui.screen.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlefrapper.foodly.data.repository.search.ISearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var searchRepository: ISearchRepository

    val searchState = MutableStateFlow<SearchState>(SearchState.Idle)

    fun search(query: String) {
        viewModelScope.launch {
            searchState.value = SearchState.Loading
            try {
                val results = searchRepository.search(query)
                searchState.value = SearchState.Success(results)
            } catch (e: Exception) {
                searchState.value = SearchState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
