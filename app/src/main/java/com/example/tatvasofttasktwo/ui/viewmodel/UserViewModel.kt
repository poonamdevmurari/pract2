package com.example.tatvasofttasktwo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.tatvasofttasktwo.data.model.User
import com.example.tatvasofttasktwo.data.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel constructor( private  val repository : UserRepository) {

    val userList = MutableLiveData<List<User>>()

    val errorMessage = MutableLiveData<String>()

    fun getUserList(){
        val response = repository.getUserList()
        response.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
              //  userList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                errorMessage.postValue(t.message)
            }

        })
    }
}