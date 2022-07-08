package com.example.kotlinserver.domain.member

import com.example.kotlinserver.domain.util.BaseEntity
import com.example.kotlinserver.dto.member.MemberDTO
import com.example.kotlinserver.dto.member.response.MemberResponseDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

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

    fun changeInfo(requestDTO: MemberDTO) {
        userNickName = requestDTO.userNickName
        age = requestDTO.age
        gender = requestDTO.gender
    }
}

@Mapper
interface MemberMapper {
    fun toMemberResponseDTO(member: Member): MemberResponseDTO

    @Mappings(
        Mapping(target = "userNickName", source = "userNickName"),
        Mapping(target = "age", source = "age"),
        Mapping(target = "gender", source = "gender")
    )
    fun toMemberDTO(member: Member): MemberDTO
}
