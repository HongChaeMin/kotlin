package com.example.kotlinserver.dto.request

import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.domain.Member

data class MemberRegisterRequestDTO(
    val userNickName: String,
    val age: Int,
    val gender: Gender
) {
    companion object {
        fun Of(requestDTO: MemberRegisterRequestDTO): Member {
            return Member(
            userNickName = requestDTO.userNickName,
            age = requestDTO.age,
            gender = requestDTO.gender
            )
        }
    }
}