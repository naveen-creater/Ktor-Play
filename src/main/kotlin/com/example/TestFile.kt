package com.example

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.serialization.descriptors.SerialKind
import java.lang.Exception
import kotlin.random.Random

fun main() {


    runBlocking {
        val channel = Channel<Int>()

            launch {
                repeat(2) {
                    delay(5000)

                    channel.send(it)
                }


            }

        repeat(10){
            launch {
                for (num in channel) {
                    println("Received number: $num")
//                delay(1000)
                }
            }
        }

        delay(15000)
        channel.close()
        println("Done!")
    }
}

fun coroutineScopeEX() {
    runBlocking<Unit> {
        val channel = Channel<String>()
        launch {
            channel.send("A1")
            channel.send("A2")
            log("A done")
        }
        launch {
            channel.send("B1")
            log("B done")
        }
        launch {
            /* repeat(6) {
                 val x = channel.receive()
                 log(x)
             }*/
            for (data in channel) {
                log(data)
            }
        }
    }


}

fun multipleToMultiple() {
    runBlocking {
        val channel = Channel<Int>()
        repeat(2) {
            launch {
                for (i in 1..5) {
                    channel.send(i)
                    delay(1000)
                }
            }
        }
        repeat(2) {
            launch {
                for (num in channel) {
                    println("Received number: $num in coroutine $it")
                    delay(1000)
                }
            }
        }
        delay(6000)
        channel.close()
        println("Done!")
    }
}

fun mulipltToSingle() {
    runBlocking {
        val channel = Channel<Int>()
        repeat(2) {
            launch {
                for (i in 1..5) {
//                    channel.send(i)
                    delay(500)
                }
            }
        }
        launch {
            for (num in channel) {
                println("Received number: $num")
                delay(1000)
            }
        }
        delay(6000)
        channel.close()
        println("Done!")
    }
}

fun log(message: Any?) {
    println("[${Thread.currentThread().name}] $message")
}

fun sampleOfScope() {
    // scope
    runBlocking {
        val handle = CoroutineExceptionHandler { coroutineContext, throwable ->

        }
        /* launch(Dispatchers.Default+CoroutineName("")+handle) {
             //cpu intensive process
             println("default dis : ${Thread.currentThread().name}")
         }*/

        /*   launch(Dispatchers.Unconfined) {
               // not conformed thread ex: changing the thread
               println("Unconfined dis : ${Thread.currentThread().name}")
               delay(1000)
               println("Unconfined dis : ${Thread.currentThread().name}")

           }*/

        /*      launch(Dispatchers.IO) {
                  // network call or file operation
                  println("io dis : ${Thread.currentThread().name}")
              }*/

        /*launch(newSingleThreadContext("My new Thread")) {
            // new Thread create and working on it
            // remember Threads are so expensive
            println("new Thread dis : ${Thread.currentThread().name}")
        }*/

        /* val value1 = async { getFirst() }
         val value2 = async { getSecond() }

         val ab = value1.await()
         val bc = value2.await()

         println("addtion: ${ab+bc}")
 */

        repeat(100_000) { // lnaunch a lot of corouties
            launch(Dispatchers.Unconfined) {
                println("Name: ${Thread.currentThread().name}")

                delay(5000L)
                println(".  ${Thread.currentThread().name}")
            }
        }
    }

}

suspend fun getFirst(): Int {
    delay(1000)
    val a = Random.nextInt(100)
    println("First one: $a")
    return a
}

suspend fun getSecond(): Int {
    delay(3000)
    val a = Random.nextInt(1000)
    println("First one: $a")
    return a
}

class Car {
    var speed = 20
    fun drive() {
        println(speed)
    }
}