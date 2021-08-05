package com.example.tatvasofttasktwo.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class UserResponse {

    @SerializedName("page")
    private val page: Int? = null

    @SerializedName("per_page")
    private val perPage: Int? = null

    @SerializedName("total")
    private val total: Int? = null

    @SerializedName("total_pages")
    private val totalPages: Int? = null

    @SerializedName("data")
    val data: List<Datum>? = null

    class Datum {

        @SerializedName("id")
         val id: Int? = null

        @SerializedName("email")
         val email: String? = null

        @SerializedName("first_name")
         val firstName: String? = null

        @SerializedName("last_name")
         val lastName: String? = null

        @SerializedName("avatar")
         val avatar: String? = null

    }


}





