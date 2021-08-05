package com.example.tatvasofttasktwo.data.network

import com.example.tatvasofttasktwo.data.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitService {

    @GET("api/users")
    fun getUserList() : Call<List<User>>

    companion object {
        var retrofitService:RetrofitService? = null
        var interceptor = HttpLoggingInterceptor()

        var client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        fun getInstance() :RetrofitService{

            if(retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/").client(client).addConverterFactory(GsonConverterFactory.create()).build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}