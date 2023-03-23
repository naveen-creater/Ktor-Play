package com.example.model

import io.ktor.resources.*

@Resource("/books")
class TypeSafeBooks(var bookNumber:Int? = 10)