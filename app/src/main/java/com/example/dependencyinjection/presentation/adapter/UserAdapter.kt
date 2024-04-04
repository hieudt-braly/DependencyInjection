package com.example.dependencyinjection.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dependencyinjection.data.User
import com.example.dependencyinjection.databinding.UserItemBinding

class UserAdapter : Adapter<UserAdapter.UserViewHolder>() {

    private var userList = listOf<User>()

    inner class UserViewHolder(private val binding: UserItemBinding) : ViewHolder(binding.root) {
        fun bind(user: User){
            binding.tvName.text = user.userName
            binding.tvAge.text = user.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun setUserList(userList: List<User>) {
        this.userList = userList
    }
}