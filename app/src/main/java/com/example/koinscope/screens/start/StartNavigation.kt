package com.example.koinscope.screens.start

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.koinscope.navigation.utils.NavRoute
import org.koin.compose.LocalKoinScope

internal val routeStart = NavRoute("route_start")

/**
 * Navigation graph description for the app router.
 */
fun NavGraphBuilder.routerScreen(onStartFlowClick: () -> Unit) {
    composable(route = routeStart.getRouteWithArguments()) { backStackEntry ->
        Log.d("DebugDestination", "Enter in ${backStackEntry.destination.route}")
        Log.d("DebugScope", "Current scope is ${LocalKoinScope.current.id}")
        StartScreen(onStartFlowClick = onStartFlowClick)
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