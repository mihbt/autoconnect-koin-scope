package com.example.koinscope.di.modules

import com.example.koinscope.model.repositories.AuthRepository
import com.example.koinscope.model.repositories.AuthRepositoryImpl
import com.example.koinscope.model.repositories.CachingStrategy
import com.example.koinscope.model.repositories.CachingStrategyImpl
import com.example.koinscope.model.repositories.DataStore
import com.example.koinscope.model.repositories.DataStoreImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {

    single {
        AuthRepositoryImpl(
            dataStore = get()
        )
    } bind AuthRepository::class

    singleOf(::DataStoreImpl) {
        bind<DataStore>()
    }

    singleOf(::CachingStrategyImpl) {
        bind<CachingStrategy>()
    }
}