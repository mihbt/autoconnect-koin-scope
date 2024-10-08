package com.example.koinscope.screens.flow1.screen2

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
fun Screen2(
    onFinishFlowClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Flow 1: Screen 2"
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onFinishFlowClick
        ) {
            Text("Finish flow")
        }
    }
}