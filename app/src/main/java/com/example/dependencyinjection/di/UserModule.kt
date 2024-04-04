package com.example.dependencyinjection.di

import com.example.dependencyinjection.setup.UserStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {
    @Provides
    @Singleton
    fun provideUserStorage(): UserStorage{
        return UserStorage()
    }
}