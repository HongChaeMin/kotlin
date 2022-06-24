package com.example.kotlinserver.util.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
        val status: HttpStatus,
        val message: String
) {

    EXPIRED_TOKEN_ERROR(HttpStatus.NOT_ACCEPTABLE, "유효하지 않은 토큰입니다."),
    NO_TOKEN_ERROR(HttpStatus.NOT_ACCEPTABLE, "존재하지 않은 토큰입니다."),
    INVALID_TOKEN_ERROR(HttpStatus.NOT_ACCEPTABLE, "토큰 에러입니다. 관리자에게 문의해주세요."),

    EXIST_NICK_NAME(HttpStatus.BAD_REQUEST, "이미 존재하는 닉네임입니다")

}