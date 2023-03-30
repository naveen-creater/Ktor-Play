package com.example

import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.random.Random

fun main() {



// scope
    runBlocking {
        val handle = CoroutineExceptionHandler{coroutineContext, throwable ->

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
            launch (Dispatchers.Unconfined){
                println("Name: ${Thread.currentThread().name}")

                delay(5000L)
                println(".  ${Thread.currentThread().name}")
            }
        }
    }





}
suspend fun getFirst() : Int{
    delay(1000)
    val a = Random.nextInt(100)
    println("First one: $a")
    return a
}

suspend fun getSecond() : Int{
    delay(3000)
    val a = Random.nextInt(1000)
    println("First one: $a")
    return a
}
class Car{
    var speed = 20
    fun drive(){
        println(speed)
    }
}