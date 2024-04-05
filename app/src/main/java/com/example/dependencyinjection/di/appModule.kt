package com.example.dependencyinjection.di

import com.example.dependencyinjection.data.UserRepository
import com.example.dependencyinjection.presentation.viewModel.UserViewModel
import com.example.dependencyinjection.setup.UserStorage
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<UserStorage> { UserStorage() }
    single<UserRepository> { UserRepository(get()) }
    viewModel { UserViewModel(get()) }
}