package com.example.kotlinserver.domain.book

import java.util.UUID

data class Book(
    var id: String = automaticNumbering(),
    val title: String,
    val price: Int,
)
private fun automaticNumbering() = UUID.randomUUID().toString()