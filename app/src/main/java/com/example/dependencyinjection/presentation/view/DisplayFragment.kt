package com.example.dependencyinjection.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.dependencyinjection.R
import com.example.dependencyinjection.databinding.FragmentDisplayBinding
import com.example.dependencyinjection.presentation.adapter.UserAdapter
import com.example.dependencyinjection.presentation.viewModel.UserViewModel

class DisplayFragment : Fragment() {
    private var _binding: FragmentDisplayBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels{UserViewModel.Factory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val userAdapter = UserAdapter()
        userAdapter.setUserList(userViewModel.getUserList())
        binding.rvUser.adapter = userAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}