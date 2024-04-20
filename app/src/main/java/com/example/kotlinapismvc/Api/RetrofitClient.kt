package com.example.kotlinapismvc.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val BASEURL: String = "https://reqres.in/api/"

    private var retrofit: Retrofit?=null

    fun getRetrofit(): Retrofit {
        if (retrofit==null){
            retrofit =Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}