package com.example.koinscope.di.utils

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.koinscope.navigation.utils.NavGraphRoute
import org.koin.compose.LocalKoinScope
import org.koin.compose.getKoin
import org.koin.core.qualifier.named

@Composable
fun AutoConnectKoinScope(
    navController: NavController,
    content: @Composable () -> Unit
) {
    val koinInstance = getKoin()
    val rootScope = LocalKoinScope.current

    var scopeToInject by remember {
        val lastKnownNavGraphRoute = lastKnownNavGraphRoute
        mutableStateOf(
            value = if (lastKnownNavGraphRoute != null) {
                koinInstance.getOrCreateScope(
                    scopeId = lastKnownNavGraphRoute,
                    qualifier = named(lastKnownNavGraphRoute)
                )
            } else {
                rootScope
            }
        )
    }

    DisposableEffect(navController) {
        val onDestinationChangedListener = NavController.OnDestinationChangedListener { _, destination, _ ->
            val currentNavGraphRoute = destination.parent?.route
            val previousNavGraphRoute = lastKnownNavGraphRoute
            Log.d("DebugDestination", "Destination is ${destination.route}")
            Log.d("DebugDestination", "Wrapping nav graph is ${currentNavGraphRoute ?: "no parent"}")
            Log.d("DebugDestination", "Last route is $previousNavGraphRoute")

            if (previousNavGraphRoute != null && currentNavGraphRoute != previousNavGraphRoute) {
                val lastScope = koinInstance.getOrCreateScope(
                    scopeId = previousNavGraphRoute,
                    qualifier = named(previousNavGraphRoute)
                )
                lastScope.close()
            }

            if (currentNavGraphRoute != null) {
                val scopeForCurrentNavGraphRoute = koinInstance.getOrCreateScope(
                    scopeId = currentNavGraphRoute,
                    qualifier = named(currentNavGraphRoute)
                )

                Log.d("DebugScope", "NavGraph not null, create scope $scopeForCurrentNavGraphRoute and link --- $currentNavGraphRoute")
                scopeToInject = scopeForCurrentNavGraphRoute
            } else {
                Log.d("DebugScope", "Use the root scope --- $currentNavGraphRoute")
                scopeToInject = rootScope
            }

            lastKnownNavGraphRoute = destination.parent?.route
        }

        navController.addOnDestinationChangedListener(onDestinationChangedListener)

        onDispose {
            navController.removeOnDestinationChangedListener(onDestinationChangedListener)
        }
    }

    CompositionLocalProvider(
        LocalKoinScope provides scopeToInject,
        content = content
    )
}

private var lastKnownNavGraphRoute: NavGraphRoute? = null