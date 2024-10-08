package com.example.koinscope.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.koinscope.di.utils.AutoConnectKoinScope
import com.example.koinscope.screens.flow1.screen1.navigateToFlow1Screen1
import com.example.koinscope.screens.flow2.screen1.navigateToFlow2Screen1
import com.example.koinscope.screens.start.routeStart
import com.example.koinscope.screens.start.routerScreen

/**
 * Navigation host for the application.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    AutoConnectKoinScope(
        navController = navController
    ) {
        NavHost(
            navController = navController,
            startDestination = routeStart.getRouteWithArguments(),
        ) {

            routerScreen(
                onStartFlow1Click = {
                    navController.navigateToFlow1Screen1()
                },
                onStartFlow2Click = {
                    navController.navigateToFlow2Screen1()
                }
            )

            flowNavGraph(
                navController = navController,
            )

            flow2NavGraph(
                navController = navController
            )
        }
    }


}
