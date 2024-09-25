package com.mlefrapper.foodly.navigation.data

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable


@Serializable
data class NavigationBarItemData(
    val route: String,
    val itemResId: Int,
    val itemImageVector: ImageVector
)