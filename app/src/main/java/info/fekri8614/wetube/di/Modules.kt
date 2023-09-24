package info.fekri8614.wetube.di

import info.fekri8614.wetube.ui.feature.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// application module
val myModules = module {
    viewModel { MainViewModel() }
}