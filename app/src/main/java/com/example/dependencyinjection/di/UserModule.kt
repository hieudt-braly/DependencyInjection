package com.example.dependencyinjection.di

import com.example.dependencyinjection.setup.UserStorage
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    fun provideUserStorage(): UserStorage{
        return UserStorage()
    }
}