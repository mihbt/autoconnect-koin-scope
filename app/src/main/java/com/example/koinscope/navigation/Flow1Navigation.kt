package com.example.koinscope.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.example.koinscope.navigation.utils.NavGraphRoute
import com.example.koinscope.screens.flow1.screen1.routeScreen1
import com.example.koinscope.screens.flow1.screen1.screen1
import com.example.koinscope.screens.flow1.screen2.navigateToFlow1Screen2
import com.example.koinscope.screens.flow1.screen2.screen2
import com.example.koinscope.screens.start.navigateToStart

const val ROUTE_GRAPH_FLOW: NavGraphRoute = "route_graph_flow"

/**
 * Navigation graph for all the features.
 */
fun NavGraphBuilder.flowNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = routeScreen1.getRouteWithPlaceholders(),
        route = ROUTE_GRAPH_FLOW,
    ) {

        screen1(
            onNextClick = {
                navController.navigateToFlow1Screen2()
            }
        )

        screen2(
            onFinishFlowClick = {
                navController.navigateToStart()
            }
        )
    }
}