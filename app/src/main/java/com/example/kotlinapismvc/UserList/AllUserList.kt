package com.example.kotlinapismvc.UserList

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapismvc.Adapter.rec_view_adapter
import com.example.kotlinapismvc.Api.RetrofitClient
import com.example.kotlinapismvc.Api.Services
import com.example.kotlinapismvc.Model.UserList.AllUserData
import com.example.kotlinapismvc.Model.UserList.Model
import retrofit2.Call
import retrofit2.Response

object AllUserList {
    fun getAllUsers(context: Context, recyclerView: RecyclerView) {
        val api: Services = RetrofitClient.getRetrofit().create(Services::class.java)
        val call: Call<Model> = api.getAllList()
        call.enqueue(object : retrofit2.Callback<Model> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<Model>,
                response: Response<Model>
            ) {
                if (response.isSuccessful) {
                    val list: List<Model.Datum>? = response.body()?.data
                    if (list != null) {

                        val adapter = rec_view_adapter(context, list)
                        adapter.notifyDataSetChanged()
                        recyclerView.adapter = adapter
                        Toast.makeText(context, "Response Successful", Toast.LENGTH_LONG).show()
                    } else {
                    }
                    Toast.makeText(context, "Response unSuccessful", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.d("hostname", t.message.toString())
                Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
            }

        })
    }
}