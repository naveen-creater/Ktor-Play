package com.example

import com.example.model.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.aboutUs(){
    routing {

        get("/") {
            val params = call.parameters
            println(params["name"])
            call.respond("Hellow world")
        }

        get("/aboutUs") {
            call.respondText("This is about us", status = HttpStatusCode.BadRequest)
        }

        get("/contactUs") {
            call.respondText(""" 
                |{"response":{"appID":"70e10e042c3a1bc1fdbb2cbb30fbb7ea","data":{},"infoID":"CX_007","infoMsg":"Configuration Error","msgID":"51bf660801f3406a3cb951e08aac0dc1","serverTime":"1676961608000","svcGroup":"Login","svcName":"Fixlogin"}}
            """.trimMargin(), status = HttpStatusCode.OK
            )
        }

        /*
        * sample of getting user params
        *headers
        * respond the custom header
        * */
        get("userName/{name}") {
            val name = call.parameters["name"]
            val host = call.request.headers["Host"] // request header
            val session = call.request.headers["Session"] // request header

            println("The Name: $name")
            println("Host: $host")
            println("The session is $session")

            if(name == "Admin"){
                call.response.header(name="CustomHeader", name) // set response header
                call.respond("Go to header tab, you will see the custom header!!")
            }else
                call.respondText("Greetings!! Hellow $name and your are now in the $host")

        }

        /*Sample of
        * queryParams
        *
        * */
        get("details") {
            val companyName = call.request.queryParameters["cName"]
            val empId = call.request.queryParameters["empId"]

            call.respond("Hi you are now working in the $companyName and your employee id is $empId")
        }

        //send json response using get method
        get("/user") {
            val user = User("Naveenkumar k", "sry not getting")
            try{
                call.respond(message = user, status =HttpStatusCode.OK )

            }catch (e:Exception){
                call.respond(message = e.message.toString(), status =HttpStatusCode.BadRequest )

            }
        }

        //redirect sample
        get("/redirect/user/data"){
            call.respondRedirect("/user")
        }

    }
}






fun ApplicationEngineEnvironmentBuilder.envConfig() {
    module {
        module()
    }
    connector {
        host = "0.0.0.0"
        port = 8080
    }
    connector {
        host = "127.0.0.1"
        port = 9090
    }
}