package com.example.koinscope.model.repositories

interface AuthRepository

class AuthRepositoryImpl(
    private val dataStore: DataStore
): AuthRepository