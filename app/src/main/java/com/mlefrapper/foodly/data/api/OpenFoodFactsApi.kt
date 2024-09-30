package com.mlefrapper.foodly.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OpenFoodFactsApi {

    private const val BASE_URL = "https://world.openfoodfacts.org/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: OpenFoodFactsApiService by lazy {
        retrofit.create(
            OpenFoodFactsApiService::class.java,
        )
    }
}
