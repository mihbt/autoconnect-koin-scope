package com.example.koinscope

import android.app.Application
import com.example.koinscope.di.modules.repositoryModule
import com.example.koinscope.di.modules.scopeModule
import com.example.koinscope.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App: Application() {

    private val koinModules: List<Module> = run {
        listOf(viewModelModule, scopeModule, repositoryModule)
    }

    override fun onCreate() {
        super.onCreate()

        // DI
        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }
    }
}