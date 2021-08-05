package com.example.tatvasofttasktwo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tatvasofttasktwo.data.repository.UserRepository
import java.lang.IllegalArgumentException

class UserViewModelFactory constructor(private val repository: UserRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(UserViewModel::class.java)){
             UserViewModel(this.repository) as T
        }else {
            throw IllegalArgumentException("Viewmodel not found")
        }

    }
}