package com.example.koinscope.screens.flow1.screen2

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.koinscope.navigation.utils.NavRoute
import org.koin.androidx.compose.koinViewModel

internal val routeScreen2 = NavRoute("route_flow1_screen2")

/**
 * Navigation graph description of [LoginScreen].
 */
internal fun NavGraphBuilder.screen2(
    onFinishFlowClick: () -> Unit,
) {
    composable(route = routeScreen2.getRouteWithPlaceholders()) { backStackEntry ->
        val viewModel: Screen2ViewModel = koinViewModel()
        Screen2(
            onFinishFlowClick = {
                onFinishFlowClick()
            }
        )
    }
}

/**
 * Navigate to [LoginScreen] screen.
 */
internal fun NavController.navigateToFlow1Screen2() {
    navigate(route = routeScreen2.getRouteWithArguments())
}
