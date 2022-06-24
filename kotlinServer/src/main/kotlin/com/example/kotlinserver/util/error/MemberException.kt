package com.example.kotlinserver.error

class ErrorResponse(private val errorCode: ErrorCode) : RuntimeException(errorCode.message) {
}