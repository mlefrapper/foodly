package com.mlefrapper.foodly.ui.screen.main.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mlefrapper.foodly.data.model.ProductDto

@Composable
fun SearchResults(results: List<ProductDto>) {
    LazyColumn {
        items(results) { product ->
            Text(
                text = product.productName ?: "",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchResultsPreview() {
    val mockResults = listOf(
        ProductDto(
            productName = "Product 1",
            brands = "",
            ingredientsText = "",
            nutriments = null,
        ),
        ProductDto(
            productName = "Product 2",
            brands = "",
            ingredientsText = "",
            nutriments = null,
        ),
        ProductDto(
            productName = "Product 3",
            brands = "",
            ingredientsText = "",
            nutriments = null,
        ),
    )
    SearchResults(
        results = mockResults,
    )
}
