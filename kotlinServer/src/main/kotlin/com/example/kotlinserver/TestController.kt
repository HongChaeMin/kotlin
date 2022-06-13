package com.example.kotlinserver

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TestController {

    @GetMapping("/test")
    fun hello(model: Model): String {
        model["massage"] = "it's test controller."
        return "hello";
    }

}