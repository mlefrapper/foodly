package com.mlefrapper.foodly.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mlefrapper.foodly.R
import com.mlefrapper.foodly.ui.theme.FoodlyTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var showSplashScreen by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = true) {
        delay(5000)
        showSplashScreen = false
    }

    if (showSplashScreen) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center,
        ) {
            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(R.raw.splash),
            )

            LottieAnimation(
                composition,
                modifier = Modifier.defaultMinSize(300.dp),
                iterations = 1,
            )
        }
    } else {
        navController.navigate("main") {
            popUpTo("splash") { inclusive = true }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    FoodlyTheme {
        SplashScreen(rememberNavController())
    }
}
