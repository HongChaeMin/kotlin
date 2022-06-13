package com.example.kotlinserver

import com.example.kotlinserver.extensions.toSlug
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinServerApplication

fun main(args: Array<String>) {
    runApplication<KotlinServerApplication>(*args)
    println("HELLO 2022-06-13T06:41:35.828+00:00".toSlug()) // hello-2022-06-13t06-41-35-828-00-00
}
