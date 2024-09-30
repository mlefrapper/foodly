package com.mlefrapper.foodly.ui.navigation.data

import com.mlefrapper.foodly.R
import kotlinx.serialization.Serializable

@Serializable
enum class NavigationBarItemData(
    val route: String,
    val itemResId: Int,
    val itemImageResId: Int,
) {
    SEARCH(
        route = "search",
        itemResId = R.string.bottom_bar_item_search,
        itemImageResId = R.drawable.ic_search,
    ),
    HISTORY(
        route = "history",
        itemResId = R.string.bottom_bar_item_history,
        itemImageResId = R.drawable.ic_history,
    ),
    SCAN(
        route = "scan",
        itemResId = R.string.bottom_bar_item_scan,
        itemImageResId = R.drawable.id_qr_code_scanner,
    ),
    RECOMMENDATIONS(
        route = "recommendations",
        itemResId = R.string.bottom_bar_item_recommendations,
        itemImageResId = R.drawable.ic_favorite,
    ),
    PROFILE(
        route = "profile",
        itemResId = R.string.bottom_bar_item_profile,
        itemImageResId = R.drawable.ic_profile,
    ),
}
