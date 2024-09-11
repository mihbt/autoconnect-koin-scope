package com.example.koinscope.screens.screen1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen1(onNextClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Flow: Screen1"
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onNextClick
        ) {
            Text("Next")
        }
    }
}