package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var name:String,
    val password:String,
)