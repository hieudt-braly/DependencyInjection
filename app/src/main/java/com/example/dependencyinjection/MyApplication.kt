package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.data.UserRepository
import com.example.dependencyinjection.setup.UserStorage

class MyApplication: Application() {
    val userStorage: UserStorage by lazy {
        UserStorage()
    }
    val userRepository: UserRepository by lazy {
        UserRepository(userStorage)
    }
}