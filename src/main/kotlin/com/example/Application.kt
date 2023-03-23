package com.example

import com.example.Routing.userData
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.locations.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.resources.*
import javax.xml.stream.Location

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
        //typeSafe
        bookData()

        userData()
    }.start(wait = true)
}

fun Application.module(){

//  aboutUs()
//  login()
}
