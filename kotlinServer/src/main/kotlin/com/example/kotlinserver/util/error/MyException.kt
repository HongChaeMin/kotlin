package com.example.kotlinserver.util.error

class MyException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)
