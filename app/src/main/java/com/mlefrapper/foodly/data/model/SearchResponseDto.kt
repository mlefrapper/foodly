package com.mlefrapper.foodly.data.model

data class SearchResponseDto(
    val count: Int,
    val page: Int,
    val page_count: Int,
    val page_size: Int,
    val products: List<ProductDto>,
)
