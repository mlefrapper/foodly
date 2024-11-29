package com.mlefrapper.foodly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.mlefrapper.foodly.ui.screen.main.MainScreen
import com.mlefrapper.foodly.ui.screen.main.search.ISearchViewModel
import com.mlefrapper.foodly.ui.screen.main.search.SearchViewModel
import com.mlefrapper.foodly.ui.theme.FoodlyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val searchViewModel: ISearchViewModel by viewModels<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodlyTheme {
                MainScreen(searchViewModel)
            }
        }
    }
}
