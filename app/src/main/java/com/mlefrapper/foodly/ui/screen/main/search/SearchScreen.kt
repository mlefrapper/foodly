package com.mlefrapper.foodly.ui.screen.main.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mlefrapper.foodly.R
import com.mlefrapper.foodly.data.repository.search.ISearchRepository
import com.mlefrapper.foodly.ui.component.SearchBar
import com.mlefrapper.foodly.ui.theme.FoodlyTheme
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel()) {
    val searchState by viewModel.searchState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        SearchBar(
            onSearch = { query ->
                coroutineScope.launch {
                    viewModel.search(query)
                }
            },
        )

        Spacer(
            modifier = Modifier.height(16.dp),
        )

        when (searchState) {
            is SearchState.Idle -> {
            }
            is SearchState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally,
                    ),
                )
            }
            is SearchState.Success -> {
                val results = (searchState as SearchState.Success).results
                if (results.isEmpty()) {
                    Text(
                        text = stringResource(R.string.no_results_found),
                        modifier = Modifier.align(
                            Alignment.CenterHorizontally,
                        ),
                    )
                } else {
                    SearchResults(results)
                }
            }
            is SearchState.Error -> {
                Text(
                    text = "Error: ${(searchState as SearchState.Error).message}",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )
            }
        }
    }
}

class FakeSearchRepository : ISearchRepository {
    override suspend fun search(query: String): List<String> {
        return emptyList()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenLoadingPreview() {
    val viewModel = SearchViewModel().apply {
        searchState.value = SearchState.Loading
    }

    FoodlyTheme {
        SearchScreen(viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenSuccessPreview() {
    val viewModel = SearchViewModel().apply {
        searchState.value = SearchState.Success(
            results = listOf(
                "Result 1",
                "Result 2",
            ),
        )
    }

    FoodlyTheme {
        SearchScreen(viewModel)
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Preview(showBackground = true)
@Composable
fun SearchScreenErrorPreview() {
    val viewModel = SearchViewModel().apply {
        searchState.value = SearchState.Error(
            message = "Network error",
        )
    }

    FoodlyTheme {
        SearchScreen(viewModel)
    }
}
