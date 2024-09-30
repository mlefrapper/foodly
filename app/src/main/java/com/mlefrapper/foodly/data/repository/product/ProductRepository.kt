package com.mlefrapper.foodly.data.repository.product

import com.mlefrapper.foodly.data.api.OpenFoodFactsApi
import com.mlefrapper.foodly.data.model.ProductDto
import javax.inject.Inject

class ProductRepository @Inject constructor() : IProductRepository {

    override suspend fun getProduct(barcode: String): ProductDto {
        return OpenFoodFactsApi.service.getProduct(barcode)
    }
}
