package com.mlefrapper.foodly.ui.screen.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.mlefrapper.foodly.ui.theme.FoodlyTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {
    val pages = listOf(
        OnboardingPage(
            imageResId = null,
            title = "Welcome!",
            description = "This is the first onboarding screen.",
        ),
        OnboardingPage(
            imageResId = null,
            title = "Features",
            description = "Explore the amazing features of our app.",
        ),
        OnboardingPage(
            imageResId = null,
            title = "Get Started",
            description = "Let's get started and enjoy the app!",
        ),
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier.weight(1f),
        ) { page ->
            OnboardingPageContent(pages[page])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = Color.Blue,
            inactiveColor = Color.Gray,
        )

        if (pagerState.currentPage == pages.size - 1) {
            Button(
                onClick = {
                    /* Handle Get Started action */
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
                Text("Get Started")
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    FoodlyTheme {
        OnBoardingScreen()
    }
}
