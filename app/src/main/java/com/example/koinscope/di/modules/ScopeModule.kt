package com.example.koinscope.di.modules

import com.example.koinscope.model.repositories.FlowRepository
import com.example.koinscope.model.repositories.FlowRepositoryImpl
import com.example.koinscope.navigation.ROUTE_GRAPH_FLOW
import com.example.koinscope.screens.screen1.Screen1ViewModel
import com.example.koinscope.screens.screen2.Screen2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val scopeModule = module {

    /**
     * Dependencies of [ROUTE_GRAPH_FLOW] scope.
     */
    scope(named(ROUTE_GRAPH_FLOW)) {

        viewModel {
            Screen1ViewModel(
                flowRepository = get(),
            )
        }

        viewModel {
            Screen2ViewModel(
                flowRepository = get(),
            )
        }

        scoped<FlowRepository> {
            FlowRepositoryImpl(
                authRepository = get()
            )
        }
    }
}