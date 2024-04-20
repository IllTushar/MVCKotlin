package com.example.kotlinapismvc.Registration

import android.content.Context
import android.widget.Toast

import com.example.kotlinapismvc.Api.RetrofitClient
import com.example.kotlinapismvc.Api.Services
import com.example.kotlinapismvc.Model.Register.RegisterResponse
import com.example.kotlinapismvc.Request.registerRequestClass

import retrofit2.Call
import retrofit2.Response


class Register {


    fun register(context: Context, email: String, password: String) {
        val api: Services = RetrofitClient.getRetrofit().create(Services::class.java)
        val request = registerRequestClass(email, password)
        val call: Call<RegisterResponse> = api.postRegister(request)
        call.enqueue(object : retrofit2.Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {

                    Toast.makeText(
                        context,
                        "Register successful ${response.body()?.id}",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(context, "Register Response failed", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
            }
        })

    }
}