package com.mlefrapper.foodly.screens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mlefrapper.foodly.R
import com.mlefrapper.foodly.navigation.data.NavigationBarItemData

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    var selectedItem by remember { mutableIntStateOf(0) }

    val items = listOf(
        NavigationBarItemData(
            route = "search",
            itemResId = R.string.bottom_bar_item_search,
            itemImageVector = Icons.Filled.Search
        ),
        NavigationBarItemData(
            route = "history",
            itemResId = R.string.bottom_bar_item_history,
            itemImageVector = Icons.Filled.DateRange
        ),
        NavigationBarItemData(
            route = "scan",
            itemResId = R.string.bottom_bar_item_scan,
            itemImageVector = Icons.Filled.Add
        ),
        NavigationBarItemData(
            route = "recommendations",
            itemResId = R.string.bottom_bar_item_recommendations,
            itemImageVector = Icons.Filled.Create
        ),
        NavigationBarItemData(
            route = "profile",
            itemResId = R.string.bottom_bar_item_profile,
            itemImageVector = Icons.Filled.Person
        )
    )
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)
                    )
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = item.itemImageVector,
                                contentDescription = context.getString(item.itemResId)
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = item.itemResId)
                            )
                        },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            navController.navigate(item.route)
                        }
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Navigation(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun Navigation(navController: androidx.navigation.NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "Search", modifier = modifier) {
        composable("Search") { SearchScreen() }
        composable("History") { HistoryScreen() }
        composable("Scan") { ScanScreen() }
        composable("Recommendations") { RecosScreen() }
        composable("Profile") { ProfileScreen() }
    }
}