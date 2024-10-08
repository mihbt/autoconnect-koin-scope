package com.example.koinscope

import android.app.Application
import com.example.koinscope.di.modules.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        // DI
        startKoin {
            androidContext(this@App)
            modules(allModules)
        }
    }
}