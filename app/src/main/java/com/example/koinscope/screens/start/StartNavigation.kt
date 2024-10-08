package com.example.koinscope.screens.start

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.koinscope.navigation.utils.NavRoute

internal val routeStart = NavRoute("route_start")

/**
 * Navigation graph description for the app router.
 */
fun NavGraphBuilder.routerScreen(
    onStartFlow1Click: () -> Unit,
    onStartFlow2Click: () -> Unit,
) {
    composable(route = routeStart.getRouteWithArguments()) { backStackEntry ->
        StartScreen(
            onStartFlow1Click = onStartFlow1Click,
            onStartFlow2Click = onStartFlow2Click
        )
    }
}

/**
 * Navigate to [LoginScreen] screen.
 */
internal fun NavController.navigateToStart() {
    navigate(route = routeStart.getRouteWithArguments()) {
        popUpTo(0)
    }
}