package com.mlefrapper.foodly.data.api

import com.mlefrapper.foodly.data.model.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenFoodFactsApiService {

    @GET("api/v0/product/{barcode}.json")
    suspend fun getProduct(
        @Path("barcode") barcode: String,
    ): ProductDto
}
