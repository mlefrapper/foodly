package com.mlefrapper.foodly.data.repository.product

import com.mlefrapper.foodly.data.model.ProductDto

interface IProductRepository {
    suspend fun getProduct(barcode: String): ProductDto
}
