package com.example.dependencyinjection.setup

import com.example.dependencyinjection.data.User

class UserStorage {
    fun getUserList() = listOf(
        User("Hieu", 21),
        User("Nam", 19),
        User("Vu", 30)
    )
}