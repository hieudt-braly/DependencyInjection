package com.example.dependencyinjection.data

import com.example.dependencyinjection.setup.UserStorage
import javax.inject.Inject

class UserRepository @Inject constructor(private val storage: UserStorage) {
    fun getUserList() = storage.getUserList()
}