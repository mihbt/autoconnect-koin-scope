package com.example.koinscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.koinscope.di.utils.AutoConnectKoinScope
import com.example.koinscope.navigation.AppNavHost
import com.example.koinscope.ui.theme.KoinScopeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainEntrypoint()
        }
    }
}

@Composable
fun MainEntrypoint() {
    KoinScopeTheme {
        val navController = rememberNavController()

        AutoConnectKoinScope(
            navController = navController,
        ) {
            AppNavHost(
                navController = navController,
            )
        }
    }
}

