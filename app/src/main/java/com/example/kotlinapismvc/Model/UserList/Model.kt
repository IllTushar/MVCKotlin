package com.example.kotlinapismvc.Model.UserList

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model {
    @SerializedName("data")
    @Expose
    var data: List<Datum>? =   null

    inner class Datum {
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("first_name")
        @Expose
        var firstName: String? = null

        @SerializedName("last_name")
        @Expose
        var lastName: String? = null

        @SerializedName("avatar")
        @Expose
        var avatar: String? = null
    }
}
