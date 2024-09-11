package com.example.koinscope.di.modules

import com.example.koinscope.screens.start.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Module for providing viewModels.
 */
internal val viewModelModule = module {

    viewModel {
        StartViewModel()
    }
}