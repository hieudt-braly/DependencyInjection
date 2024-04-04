package com.example.dependencyinjection.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.dependencyinjection.MyApplication
import com.example.dependencyinjection.data.UserRepository

class UserViewModel(
    val userRepository: UserRepository
): ViewModel() {
    fun getUserList() = userRepository.getUserList()

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras

                return UserViewModel(
                    (application as MyApplication).userRepository,
                ) as T
            }
        }
    }
}