package com.example.kotlinserver.dto.member

import com.example.kotlinserver.domain.member.Gender
import com.example.kotlinserver.domain.member.Member

data class MemberDTO(
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
