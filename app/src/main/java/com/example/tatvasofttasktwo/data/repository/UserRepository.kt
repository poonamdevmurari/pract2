package com.example.tatvasofttasktwo.data.repository

import com.example.tatvasofttasktwo.data.network.RetrofitService

class UserRepository constructor(private val retrofitService: RetrofitService) {

    fun getUserList() = retrofitService.getUserList()
}