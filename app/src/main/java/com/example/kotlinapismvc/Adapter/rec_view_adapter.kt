package com.example.kotlinapismvc.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinapismvc.Model.UserList.AllUserData
import com.example.kotlinapismvc.Model.UserList.Model
import com.example.kotlinapismvc.R

class rec_view_adapter(var context: Context, var list: List<Model.Datum>) :
    RecyclerView.Adapter<rec_view_adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.single_row_xml, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            Glide.with(context).load(list[position].avatar).into(holder.image)
            val string: String = list[position].email.toString()
            holder.textView.text = string

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var textView: TextView

        init {
            image = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView1)
        }
    }
}
