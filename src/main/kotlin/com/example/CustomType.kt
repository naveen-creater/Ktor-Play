package com.example

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.someCustom(){
    routing {
        route("/customPath", HttpMethod.Get){
            handle {

            }
        }

        get("/getUri") {
            val uri = call.request.uri
//            call.response.status(HttpStatusCode.NotFound)

            /*val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )*/

            call.response.status(HttpStatusCode(412,"Hii"))
            call.respond("Request uri: $uri")
        }

        post("") {

        }
    }
}