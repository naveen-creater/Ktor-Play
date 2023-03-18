package com.example

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.someCustom(){
    routing {
        route("/customPath", HttpMethod.Get){
            handle {

            }
        }

        get("") {

        }

        post("") {

        }
    }
}