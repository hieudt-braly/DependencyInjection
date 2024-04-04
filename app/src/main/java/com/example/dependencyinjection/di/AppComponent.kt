package com.example.dependencyinjection.di

import com.example.dependencyinjection.presentation.view.DisplayFragment
import com.example.dependencyinjection.setup.UserStorage
import dagger.Component

@Component(modules = [UserModule::class])
interface AppComponent {
    fun inject(displayFragment: DisplayFragment)
}