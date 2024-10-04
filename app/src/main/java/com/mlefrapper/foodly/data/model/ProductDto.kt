package com.mlefrapper.foodly.data.model

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("product_name") val productName: String?,
    @SerializedName("brands") val brands: String?,
    @SerializedName("ingredients_text") val ingredientsText: String?,
    @SerializedName("nutriments") val nutriments: NutrimentsDto?,
)
