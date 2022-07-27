package com.example.kotlinserver.dto.visitor.response

import com.example.kotlinserver.domain.member.Gender

data class ResponseVisitorUserDTO(
    private val userId: Long,
    private val age: Int,
    private val gender: Gender
)
