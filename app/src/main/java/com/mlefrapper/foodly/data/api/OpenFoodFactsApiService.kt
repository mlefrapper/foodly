package com.mlefrapper.foodly.data.api

import com.mlefrapper.foodly.data.model.ProductDto
import com.mlefrapper.foodly.data.model.SearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenFoodFactsApiService {

    @GET("api/v0/product/{barcode}.json")
    suspend fun getProduct(
        @Path("barcode") barcode: String,
    ): ProductDto

    @GET("cgi/search.pl")
    suspend fun searchProductByName(
        @Query("search_terms") productName: String,
        @Query("search_simple") searchSimple: Int,
        @Query("action") action: String,
        @Query("json") json: Int,
    ): SearchResponseDto
}
