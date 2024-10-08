package com.example.koinscope.screens.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen(
    onStartFlow1Click: () -> Unit,
    onStartFlow2Click: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Start flow 1 - tied to a scoped"
        )

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onStartFlow1Click
        ) {
            Text("Start flow 1")
        }

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Start flow 2 - not tied to a scope"
        )

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onStartFlow2Click
        ) {
            Text("Start flow 2")
        }
    }
}