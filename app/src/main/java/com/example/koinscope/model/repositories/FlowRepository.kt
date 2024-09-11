package com.example.koinscope.model.repositories

import android.util.Log

interface FlowRepository

class FlowRepositoryImpl(
    authRepository: AuthRepository
): FlowRepository {

    init {
        Log.d("DebugInject", "Auth repository instance is $authRepository")
    }
}