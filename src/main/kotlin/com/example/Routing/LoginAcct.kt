package com.example

import com.example.model.User
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.math.log

fun Application.login(){
    routing {
        post("/login") {
            try{
                val user = call.receive<User>()
                call.respond(message = user, status = HttpStatusCode.OK)

            }catch (e:Exception){
                val ap = e.message
                println(ap)
                call.respond("Login fail")

            }

//            println(user)

        }

        get("/"){
            call.respond(status = HttpStatusCode(description = "OK for init", value = 200),
                message = "Application Working fine"
            )
        }
    }
}

fun Application.signUp(){
   routing {


   }
}