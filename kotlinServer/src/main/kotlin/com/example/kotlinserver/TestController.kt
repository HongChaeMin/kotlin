package com.example.kotlinserver

import com.example.kotlinserver.dto.MemberDTO
import com.example.kotlinserver.util.ApiResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.StandardCharsets
import javax.servlet.ServletInputStream
import javax.servlet.http.HttpServletRequest

@RestController
class TestController {

    private val objectMapper = ObjectMapper()

    @GetMapping("/test")
    fun hello(model: Model): String {
        model["massage"] = "it's test controller."
        return "hello"
    }

    @PostMapping(value = ["api/v1/system/banner/update"])
    fun updateBanner(req: HttpServletRequest, @RequestBody requestDTO: MemberDTO): ApiResponse<String> {
        // @RequestBody 를 사용하면 메세지 컨버터가 먼저 HTTP message body 의 내용을 읽어서 HttpServletRequest 로 못 읽는 듯
        val inputStream: ServletInputStream = req.inputStream

        val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)
        println("messageBody : $messageBody")

        // val memberDTO = objectMapper.readValue(messageBody, MemberDTO::class)

        println("request : $req")
        println("${req.parameterNames}")

        return ApiResponse.Success("OK", "OK")
    }
}
