package com.example.kotlinserver.util.handler

import com.example.kotlinserver.util.ApiResponse
import com.example.kotlinserver.util.error.MyException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// @ControllerAdvice + @ResponseBody
// controller 에 대한 전역으로 발생하는 예외를 잡아서 처리할 수 있음 (AOP)
@RestControllerAdvice
class ExceptionHandler() {

    @ExceptionHandler(MyException::class)
    fun handleMemberException(e: MyException): ApiResponse.Error<HttpStatus> {
        return ApiResponse.Error(e.errorCode.status, e.message)
    }
}
