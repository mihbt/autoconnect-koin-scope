package com.example.koinscope.di.modules

import com.example.koinscope.screens.flow2.screen1.Screen1ViewModel
import com.example.koinscope.screens.flow2.screen2.Screen2ViewModel
import com.example.koinscope.screens.start.StartViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Module for providing viewModels.
 */
internal val viewModelModule = module {

//    viewModel {
//        StartViewModel()
//    }

    viewModelOf(::StartViewModel)


    viewModelOf(::Screen1ViewModel)

//    viewModel {
//        Screen1ViewModel()
//    }

    viewModelOf(::Screen2ViewModel)
//    viewModel {
//        Screen2ViewModel()
//    }
}