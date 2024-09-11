package com.example.koinscope.di.modules

import com.example.koinscope.model.repositories.AuthRepository
import com.example.koinscope.model.repositories.AuthRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<AuthRepository> {
        AuthRepositoryImpl()
    }
}