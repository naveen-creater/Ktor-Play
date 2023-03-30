package com.example.plugin

import com.example.model.UserData
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.*

val RequestLoggingPlugin = createApplicationPlugin(name = "com.example.plugin.getRequestLoggingPlugin") {
    val onCallTimeKey = AttributeKey<Long>("onCallTimeKey")


    onCall { call ->
        call.request.origin.apply {
            println("Request URL: $scheme://$localHost:$localPort$uri")
            call.response.header("Food","Briyani")
        }
    }

    onCallReceive{ call ->

        val onCallReceiveTime = System.currentTimeMillis()
        println("Read body delay (ms): $onCallReceiveTime")
    }


}