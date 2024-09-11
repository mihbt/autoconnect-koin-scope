package com.example.koinscope.navigation.utils

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Describes a navigation route to a composable screen.
 */
data class NavRoute(val base: String, val argumentPlaceholders: List<String> = listOf()) {

    /**
     * Get the route with the given [arguments].
     */
    fun getRouteWithArguments(arguments: List<String> = listOf()): String {
        if (arguments.size != argumentPlaceholders.size) {
            throw IllegalArgumentException("Number of arguments doesn't match the number of placeholders")
        }

        return arguments.fold(base) { route, argument ->
            "$route/$argument"
        }
    }

    /**
     * Get the route with the given [argumentPlaceholders].
     */
    fun getRouteWithPlaceholders(): String {
        return argumentPlaceholders.fold(base) { route, argumentPlaceholder ->
            "$route/{$argumentPlaceholder}"
        }
    }

    /**
     * Get the route arguments.
     */
    fun getArguments(): List<NamedNavArgument> {
        return argumentPlaceholders.map { argumentPlaceholder ->
            navArgument(argumentPlaceholder) { type = NavType.StringType }
        }
    }
}