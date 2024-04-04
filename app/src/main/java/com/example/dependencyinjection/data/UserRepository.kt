package com.example.dependencyinjection.data

import com.example.dependencyinjection.setup.UserStorage

class UserRepository(private val storage: UserStorage) {
    fun getUserList() = storage.getUserList()
}