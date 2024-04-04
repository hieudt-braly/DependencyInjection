package com.example.dependencyinjection.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.dependencyinjection.MyApplication
import com.example.dependencyinjection.data.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(
    val userRepository: UserRepository
): ViewModel() {
    fun getUserList() = userRepository.getUserList()
}