package com.example.koinscope.screens.flow1.screen1

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.koinscope.model.repositories.FlowRepository

class Screen1ViewModel(
    private val flowRepository: FlowRepository,
): ViewModel() {

    init {
        Log.d("DebugInjection", "Flow repository instance is $flowRepository")
    }
}