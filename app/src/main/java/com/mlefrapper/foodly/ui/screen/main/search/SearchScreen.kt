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
import com.mlefrapper.foodly.R
import com.mlefrapper.foodly.data.model.ProductDto
import com.mlefrapper.foodly.data.model.SearchResponseDto
import com.mlefrapper.foodly.data.repository.product.IProductRepository
import com.mlefrapper.foodly.domain.usecase.GetProductsByNameUseCase
import com.mlefrapper.foodly.ui.component.SearchBar
import com.mlefrapper.foodly.ui.theme.FoodlyTheme
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(viewModel: ISearchViewModel) {
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

                if (results.count == 0) {
                    Text(
                        text = stringResource(R.string.no_results_found),
                        modifier = Modifier.align(
                            Alignment.CenterHorizontally,
                        ),
                    )
                } else {
                    SearchResults(results.products)
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

class FakeProductRepository : IProductRepository {
    override suspend fun getProduct(barcode: String): ProductDto {
        return ProductDto(
            productName = "Product 1",
            brands = "",
            ingredientsText = "",
            nutriments = null,
        )
    }
    override suspend fun getProductsByName(productName: String): SearchResponseDto {
        return SearchResponseDto(
            count = 1,
            page = 1,
            page_count = 1,
            page_size = 1,
            products = listOf(
                ProductDto(
                    productName = "Mock Product",
                    brands = "",
                    ingredientsText = null,
                    nutriments = null,
                ),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenLoadingPreview() {
    val viewModel = SearchViewModel(
        GetProductsByNameUseCase(FakeProductRepository()),
    ).apply {
        searchState.value = SearchState.Loading
    }

    FoodlyTheme {
        SearchScreen(viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenSuccessPreview() {
    val viewModel = SearchViewModel(
        GetProductsByNameUseCase(FakeProductRepository()),
    ).apply {
        searchState.value = SearchState.Success(
            results = SearchResponseDto(
                count = 1,
                page = 1,
                page_count = 1,
                page_size = 1,
                products = listOf(
                    ProductDto(
                        productName = "Product 1",
                        brands = "",
                        ingredientsText = "",
                        nutriments = null,
                    ),
                ),
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
    val viewModel = SearchViewModel(
        GetProductsByNameUseCase(FakeProductRepository()),
    ).apply {
        searchState.value = SearchState.Error(
            message = "Network error",
        )
    }

    FoodlyTheme {
        SearchScreen(viewModel)
    }
}
