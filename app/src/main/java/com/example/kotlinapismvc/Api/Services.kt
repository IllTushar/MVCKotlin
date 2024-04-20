package com.example.kotlinapismvc.Api

import com.example.kotlinapismvc.Model.Register.RegisterResponse
import com.example.kotlinapismvc.Model.UserList.AllUserData
import com.example.kotlinapismvc.Model.UserList.Model
import com.example.kotlinapismvc.Request.registerRequestClass
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Services {

    /*
    suspend keyword indicates that these functions are suspend functions and can be called from a coroutine.
    This is common when working with APIs in Kotlin, especially in Android development.
     */
    @POST("register")
    fun postRegister(
        @Body registerRequestClass: registerRequestClass
    ): Call<RegisterResponse>

    @GET("users?page=2")
    fun getAllList(): Call<Model>
}