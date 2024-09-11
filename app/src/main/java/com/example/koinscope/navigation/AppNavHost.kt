package com.example.koinscope.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.koinscope.screens.screen1.navigateToScreen1
import com.example.koinscope.screens.start.routeStart
import com.example.koinscope.screens.start.routerScreen

/**
 * Navigation host for the application.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = routeStart.getRouteWithArguments(),
    ) {

        routerScreen(
            onStartFlowClick = {
                navController.navigateToScreen1()
            }
        )

        flowNavGraph(
            navController = navController,
        )
    }
}
