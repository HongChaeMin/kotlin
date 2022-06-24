package com.example.kotlinserver.error

enum class ErrorCode(val message: String) {

    EXPIRED_TOKEN_ERROR("유효하지 않은 토큰입니다."),
    NO_TOKEN_ERROR("존재하지 않은 토큰입니다."),
    INVALID_TOKEN_ERROR("토큰 에러입니다. 관리자에게 문의해주세요."),

    EXIST_NICK_NAME("이미 존재하는 닉네임입니다")

}