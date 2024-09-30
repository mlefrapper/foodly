package com.mlefrapper.foodly.ui.screen.main.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchResults(results: List<String>) {
    LazyColumn {
        items(results) { result ->
            Text(
                text = result,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchResultsPreview() {
    val mockResults = listOf(
        "Result 1",
        "Result 2",
        "Result 3",
    )
    SearchResults(
        results = mockResults,
    )
}
