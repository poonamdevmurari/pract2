package com.example.tatvasofttasktwo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tatvasofttasktwo.data.model.UserResponse
import com.example.tatvasofttasktwo.data.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel constructor( private  val repository : UserRepository) : ViewModel() {

    val userList = MutableLiveData<UserResponse>()

    val errorMessage = MutableLiveData<String>()

    fun getUserList(){
        val response = repository.getUserList()
        response.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                userList.postValue(response.body())
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {

                errorMessage.postValue(t.message)
            }

        })
    }
}