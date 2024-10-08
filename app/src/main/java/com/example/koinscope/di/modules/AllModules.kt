package com.example.koinscope.di.modules

import org.koin.core.module.Module
import org.koin.dsl.module

val allModules: Module = module {
    includes(
        viewModelModule,
        repositoryModule,
        scopeModule
    )
}