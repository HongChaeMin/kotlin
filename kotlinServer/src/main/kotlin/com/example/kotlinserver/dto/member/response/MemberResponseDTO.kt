package com.example.kotlinserver.dto.member.response

import com.example.kotlinserver.domain.Gender

class MemberResponseDTO(
    val id: Long?,
    val userNickName: String,
    val age: Int,
    val gender: Gender
)
