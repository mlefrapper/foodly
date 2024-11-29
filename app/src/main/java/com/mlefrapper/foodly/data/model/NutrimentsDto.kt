package com.mlefrapper.foodly.data.model

import com.google.gson.annotations.SerializedName

data class NutrimentsDto(
    @SerializedName("energy-kcal_100g") val energyKcal100g: Double?,
    @SerializedName("fat_100g") val fat100g: Double?,
)
