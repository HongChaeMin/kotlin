package com.example.kotlinserver.util.error

class MemberException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)