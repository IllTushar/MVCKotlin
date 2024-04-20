package com.example.kotlinapismvc

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapismvc.Adapter.rec_view_adapter
import com.example.kotlinapismvc.Api.RetrofitClient
import com.example.kotlinapismvc.Api.Services
import com.example.kotlinapismvc.Model.UserList.AllUserData
import com.example.kotlinapismvc.Registration.Register
import com.example.kotlinapismvc.UserList.AllUserList
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var submit: Button
    lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        submit = findViewById(R.id.submit)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
//        submit.setOnClickListener {
////            callApi()
//            submit.visibility = View.GONE
//            recyclerView.visibility = View.VISIBLE
////            getAllUsers()
//        }

        AllUserList.getAllUsers(this@MainActivity, recyclerView)

    }

    private fun callApi() {
        val apiCall = Register()
        apiCall.register(
            this@MainActivity,
            email.text.toString().trim(),
            password.text.toString().trim()
        )

    }


}