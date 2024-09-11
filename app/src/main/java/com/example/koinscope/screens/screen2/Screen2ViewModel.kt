package com.example.koinscope.screens.screen2

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.koinscope.model.repositories.FlowRepository

class Screen2ViewModel(
    private val flowRepository: FlowRepository
): ViewModel() {

    init {
        Log.d("DebugInjection", "Flow repository instance is $flowRepository")
    }
}