package com.mlefrapper.foodly.data.repository.product

import com.mlefrapper.foodly.data.api.OpenFoodFactsApi
import com.mlefrapper.foodly.data.model.ProductDto
import com.mlefrapper.foodly.data.model.SearchResponseDto
import javax.inject.Inject

class ProductRepository @Inject constructor() : IProductRepository {

    override suspend fun getProduct(barcode: String): ProductDto {
        return OpenFoodFactsApi.service.getProduct(barcode)
    }

    override suspend fun getProductsByName(productName: String): SearchResponseDto {
        return OpenFoodFactsApi.service.searchProductByName(
            productName = productName,
            searchSimple = 1,
            action = "process",
            json = 1,
        )
    }
}
