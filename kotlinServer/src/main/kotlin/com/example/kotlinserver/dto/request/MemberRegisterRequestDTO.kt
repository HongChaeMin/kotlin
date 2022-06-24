package com.example.kotlinserver.dto.request

import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.domain.Member

data class MemberRegisterRequestDTO (
    val userNickName: String,
    val age: Int,
    val gender: Gender
) {
    fun toEntity(): Member {
        return Member(
            userNickName = this.userNickName,
            age = this.age,
            gender = this.gender
        )
    }
}