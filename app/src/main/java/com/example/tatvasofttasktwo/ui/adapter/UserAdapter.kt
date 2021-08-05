package com.example.tatvasofttasktwo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tatvasofttasktwo.data.model.User
import com.example.tatvasofttasktwo.data.model.UserResponse
import com.example.tatvasofttasktwo.databinding.ListItemBinding

class UserAdapter(val userList : MutableList<UserResponse.Datum>) : RecyclerView.Adapter<UserAdapter.CustomViewHolder> () {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding  = ListItemBinding.inflate(inflater, parent, false)
        return  CustomViewHolder(binding)

    }



    override fun onBindViewHolder(holder: UserAdapter.CustomViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.userName.text = user.firstName + user.lastName
        holder.binding.userEmail.text = user.email
        Glide.with(holder.itemView.context).load(user.avatar).into(holder.binding.userImage)
    }

    override fun getItemCount(): Int = userList.size

    inner class CustomViewHolder(val binding : ListItemBinding):RecyclerView.ViewHolder(binding.root)
}