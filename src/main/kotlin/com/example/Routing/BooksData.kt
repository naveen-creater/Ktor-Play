package com.example

import com.example.model.TypeSafeBooks
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.bookData(){
    install(Resources)

    routing {

        get<TypeSafeBooks>{
//            it.bookNumber = call.request.queryParameters["bookNumber"]?.toInt()

            call.respondText("First of all this is type-safe routing. " +
                    "bookid ${it.bookNumber}", status = HttpStatusCode.OK)
        }

    }
}