package com.example

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


fun Application.clientCall(){
    val client = HttpClient(CIO)


    routing {

        get("/config_dev"){

            val firstRequest: Deferred<String> = async {
                client.get("https://cxopen-dev.fxdnld.mobi/config_dev.json").bodyAsText() }

            call.respond(firstRequest.await())

//            client.close()

        }
    }
}