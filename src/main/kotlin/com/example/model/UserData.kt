package com.example.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    @SerialName("name")
    var name:String,
    @SerialName("age")
    var age:Int,
    @SerialName("id")
    var id:Int,
    @SerialName("maritalStatus")
    val maritalStatus:String
)