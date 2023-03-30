package com.example

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

/*fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)*/

fun main(){

    embeddedServer(Netty, port = 8080){
      install(ContentNegotiation){
        json()
      }

        module()
        aboutUs()
        login()
        someCustom()

    }.start(wait = true)
}

fun Application.module(){
//
//  aboutUs()
//  login()
}