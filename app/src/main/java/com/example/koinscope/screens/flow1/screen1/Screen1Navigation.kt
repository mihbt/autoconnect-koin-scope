package com.example.koinscope.screens.flow1.screen1

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.koinscope.navigation.utils.NavRoute
import org.koin.androidx.compose.koinViewModel

internal val routeScreen1 = NavRoute("route_flow1_screen1")

/**
 * Navigation graph description of [LoginScreen].
 */
internal fun NavGraphBuilder.screen1(
    onNextClick: () -> Unit
) {
    composable(route = routeScreen1.getRouteWithPlaceholders()) { backStackEntry ->
        val viewModel: Screen1ViewModel = koinViewModel()
        Screen1(onNextClick)
    }
}

/**
 * Navigate to [LoginScreen] screen.
 */
internal fun NavController.navigateToFlow1Screen1() {
    navigate(route = routeScreen1.getRouteWithArguments())
}
