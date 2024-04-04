package com.example.dependencyinjection.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dependencyinjection.MainActivity
import com.example.dependencyinjection.MyApplication
import com.example.dependencyinjection.databinding.FragmentDisplayBinding
import com.example.dependencyinjection.presentation.adapter.UserAdapter
import com.example.dependencyinjection.presentation.viewModel.UserViewModel
import javax.inject.Inject

class DisplayFragment : Fragment() {
    private var _binding: FragmentDisplayBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        (activity as MainActivity).appComponent.inject(this)
        super.onAttach(context)
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