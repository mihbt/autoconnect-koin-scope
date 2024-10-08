package com.example.koinscope.di.modules

import com.example.koinscope.model.repositories.FlowRepository
import com.example.koinscope.model.repositories.FlowRepositoryImpl
import com.example.koinscope.navigation.ROUTE_GRAPH_FLOW
import com.example.koinscope.screens.flow1.screen1.Screen1ViewModel
import com.example.koinscope.screens.flow1.screen2.Screen2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.scopedOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val scopeModule = module {

    /**
     * Dependencies of [ROUTE_GRAPH_FLOW] scope.
     */
    scope(named(ROUTE_GRAPH_FLOW)) {

        viewModelOf(::Screen1ViewModel)
//        viewModel {
//            Screen1ViewModel(
//                flowRepository = get(),
//            )
//        }

        viewModelOf(::Screen2ViewModel)
//        viewModel {
//            Screen2ViewModel(
//                flowRepository = get(),
//            )
//        }

//        scoped<FlowRepository> {
//            FlowRepositoryImpl(
//                authRepository = get()
//            )
//        }

        scopedOf(::FlowRepositoryImpl) {
            bind<FlowRepository>()
        }
    }
}