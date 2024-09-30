package com.mlefrapper.foodly.ui.screen.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mlefrapper.foodly.ui.navigation.data.NavigationBarItemData
import com.mlefrapper.foodly.ui.screen.main.history.HistoryScreen
import com.mlefrapper.foodly.ui.screen.main.profile.ProfileScreen
import com.mlefrapper.foodly.ui.screen.main.recommendations.RecosScreen
import com.mlefrapper.foodly.ui.screen.main.scan.ScanScreen
import com.mlefrapper.foodly.ui.screen.main.search.SearchScreen
import com.mlefrapper.foodly.ui.shapes.CustomRoundedShape
import com.mlefrapper.foodly.ui.theme.Gray
import com.mlefrapper.foodly.ui.theme.LightGreen
import com.mlefrapper.foodly.ui.theme.Orange
import com.mlefrapper.foodly.ui.theme.White

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    var selectedItem by remember { mutableIntStateOf(0) }

    val items = listOf(
        NavigationBarItemData.SEARCH,
        NavigationBarItemData.HISTORY,
        NavigationBarItemData.SCAN,
        NavigationBarItemData.RECOMMENDATIONS,
        NavigationBarItemData.PROFILE,
    )

    val fabShape = CustomRoundedShape(
        cornerRadius = 16.dp,
        circleRadius = 30.dp,
    )
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(fabShape)
                    .shadow(
                        elevation = 10.dp,
                        shape = fabShape,
                    ),
                containerColor = White,
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            if (item != NavigationBarItemData.SCAN) {
                                Icon(
                                    painter = painterResource(id = item.itemImageResId),
                                    contentDescription = context.getString(item.itemResId),
                                )
                            } else {
                                Spacer(modifier = Modifier.size(24.dp))
                            }
                        },
                        label = {
                            Text(
                                text = stringResource(id = item.itemResId),
                            )
                        },
                        selected = selectedItem == index,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = LightGreen,
                            selectedTextColor = LightGreen,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Gray,
                            unselectedTextColor = Gray,
                            disabledIconColor = Gray,
                            disabledTextColor = Gray,
                        ),
                        onClick = {
                            selectedItem = index
                            navController.navigate(item.route)
                        },
                    )
                }
            }
        },
        floatingActionButton = {
            val item = NavigationBarItemData.SCAN
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavigationBarItemData.SCAN.route)
                },
                modifier = Modifier.offset(
                    x = 0.dp,
                    y = 40.dp,
                ),
                shape = CircleShape,
                containerColor = White,
                contentColor = Orange,
            ) {
                Icon(
                    painter = painterResource(id = item.itemImageResId),
                    contentDescription = context.getString(item.itemResId),
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Navigation(
            navController = navController,
            modifier = Modifier
                .padding(innerPadding)
                .navigationBarsPadding(),
        )
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
