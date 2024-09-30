package com.mlefrapper.foodly.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mlefrapper.foodly.ui.screen.main.MainScreen
import com.mlefrapper.foodly.ui.screen.onboarding.OnBoardingScreen
import com.mlefrapper.foodly.ui.screen.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("onBoarding") { OnBoardingScreen() }
        composable("main") { MainScreen() }
    }
}
