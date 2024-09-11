package com.example.koinscope.screens.screen1

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.koinscope.navigation.utils.NavRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.LocalKoinScope

internal val routeScreen1 = NavRoute("route_screen1")

/**
 * Navigation graph description of [LoginScreen].
 */
internal fun NavGraphBuilder.screen1(
    onNextClick: () -> Unit
) {
    composable(route = routeScreen1.getRouteWithPlaceholders()) { backStackEntry ->
        Log.d("DebugDestination", "Enter in ${backStackEntry.destination.route}")
        Log.d("DebugScope", "Current scope is ${LocalKoinScope.current.id}")

        val viewModel: Screen1ViewModel = koinViewModel()
        Screen1(onNextClick)
    }
}

/**
 * Navigate to [LoginScreen] screen.
 */
internal fun NavController.navigateToScreen1() {
    navigate(route = routeScreen1.getRouteWithArguments())
}
