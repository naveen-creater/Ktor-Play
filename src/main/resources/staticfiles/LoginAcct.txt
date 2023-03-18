package com.example

import com.example.model.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.math.log

fun Application.login(){
    routing {
        post("/login") {
            val user = call.receive<User>()
            println(user)

            call.respond(user)
        }
    }
}

fun Application.signUp(){
   routing {


   }
}