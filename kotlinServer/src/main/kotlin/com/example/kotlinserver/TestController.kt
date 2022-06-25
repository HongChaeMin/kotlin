package com.example.kotlinserver

import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test")
    fun hello(model: Model): String {
        model["massage"] = "it's test controller."
        return "hello"
    }
}