package com.example.Routing

import com.example.model.UserData
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

object Utils{
    val listOfData =  mutableListOf<UserData>();
}

fun Application.userData(){

    routing {

        post("/putUserData") {
            val data = call.receive<UserData>()
            println(data)
            Utils.listOfData.add(data)

            call.respond(message = "user data store success!!", status = HttpStatusCode.OK)
        }

        get("/getAllUserData") {

            if(Utils.listOfData.size == 0){
                call.respond(message = "User data is empty!", status = HttpStatusCode.Found)
            }else{
                call.respond(Utils.listOfData)
            }

        }

        get("/deleteAllData"){
            Utils.listOfData.clear()
            call.respond(message = "all data is clear now", status = HttpStatusCode.Forbidden)
        }

        get("/userData/{id}") {
            val id:Int? = call.parameters["id"]?.toInt()
            var d:UserData? = null

            if(Utils.listOfData.size != 0){
                Utils.listOfData.forEach {
                    if(id!=null && it.id == id){
                        d = it
                    }
                }

                if(d != null){
                    call.respond(d!!)
                }else{
                    call.respond(message = "Not geting form this id: $id", status = HttpStatusCode.NotFound)
                }

            }else{
                call.respond(message = "User data is empty!", status = HttpStatusCode.Found)
            }


        }

        get("/userData/delete/{id}") {
            val id:Int? = call.parameters["id"]?.toInt()
            var data:UserData? = null

            Utils.listOfData.forEach {
                if(id!=null && it.id == id){
                    data = it
                }
            }

            if(data!=null){
                Utils.listOfData.remove(data)
                call.respondText("Success!!")
            }else{
                call.respondText("Not getting this id: $id !!")
            }

        }

    }
}