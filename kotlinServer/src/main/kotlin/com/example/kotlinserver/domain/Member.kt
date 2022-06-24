package com.example.kotlinserver.domain

import com.example.kotlinserver.dto.response.MemberResponseDTO
import javax.persistence.*

@Entity
class Member (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var userNickName: String,
    var age: Int,

    @Enumerated(EnumType.STRING)
    var gender: Gender

) : BaseEntity() {
    fun toResponseDTO(): MemberResponseDTO {
        return MemberResponseDTO(
                id = this.id,
                userNickName = this.userNickName,
                age = this.age,
                gender = this.gender
        )
    }
}
