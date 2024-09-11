package com.example.koinscope.screens.screen2

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.koinscope.navigation.utils.NavRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.LocalKoinScope

internal val routeScreen2 = NavRoute("route_screen2")

/**
 * Navigation graph description of [LoginScreen].
 */
internal fun NavGraphBuilder.screen2(
    onFinishFlowClick: () -> Unit,
) {
    composable(route = routeScreen2.getRouteWithPlaceholders()) { backStackEntry ->
        Log.d("DebugDestination", "Enter in ${backStackEntry.destination.route}")
        Log.d("DebugScope", "Current scope is ${LocalKoinScope.current.id}")

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
internal fun NavController.navigateToScreen2() {
    navigate(route = routeScreen2.getRouteWithArguments())
}
