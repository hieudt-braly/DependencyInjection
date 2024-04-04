package com.example.dependencyinjection.di

import com.example.dependencyinjection.data.UserRepository
import com.example.dependencyinjection.setup.UserStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository{
        return UserRepository(userStorage)
    }
}