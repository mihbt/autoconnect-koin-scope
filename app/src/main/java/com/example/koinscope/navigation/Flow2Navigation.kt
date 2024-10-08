package com.example.koinscope.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.example.koinscope.navigation.utils.NavGraphRoute
import com.example.koinscope.screens.flow2.screen1.routeScreen1
import com.example.koinscope.screens.flow2.screen1.screen1
import com.example.koinscope.screens.flow2.screen2.navigateToFlow2Screen2
import com.example.koinscope.screens.flow2.screen2.screen2
import com.example.koinscope.screens.start.navigateToStart

const val ROUTE_GRAPH_FLOW_2: NavGraphRoute = "route_graph_flow_2"

/**
 * Navigation graph for all the features.
 */
fun NavGraphBuilder.flow2NavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = routeScreen1.getRouteWithPlaceholders(),
        route = ROUTE_GRAPH_FLOW_2,
    ) {

        screen1(
            onNextClick = {
                navController.navigateToFlow2Screen2()
            }
        )

        screen2(
            onFinishFlowClick = {
                navController.navigateToStart()
            }
        )
    }
}