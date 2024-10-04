package com.mlefrapper.foodly.ui.screen.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlefrapper.foodly.domain.usecase.GetProductsByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getProductsByNameUseCase: GetProductsByNameUseCase,
) : ViewModel(), ISearchViewModel {

    override val searchState: MutableStateFlow<SearchState>
        get() = MutableStateFlow(SearchState.Idle)

    override fun search(query: String) {
        viewModelScope.launch {
            searchState.value = SearchState.Loading
            try {
                val results = getProductsByNameUseCase.invoke(query)
                searchState.value = SearchState.Success(results)
            } catch (e: Exception) {
                Timber.e(e.message)
                searchState.value = SearchState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
