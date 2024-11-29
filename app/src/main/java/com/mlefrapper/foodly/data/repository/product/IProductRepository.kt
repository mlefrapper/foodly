package com.mlefrapper.foodly.data.repository.product

import com.mlefrapper.foodly.data.model.ProductDto
import com.mlefrapper.foodly.data.model.SearchResponseDto

interface IProductRepository {
    suspend fun getProduct(barcode: String): ProductDto
    suspend fun getProductsByName(productName: String): SearchResponseDto
}
