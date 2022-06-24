package com.example.kotlinserver.service

import com.example.kotlinserver.dto.MemberDTO
import com.example.kotlinserver.dto.response.MemberResponseDTO

interface MemberService {
    fun registerMember(memberRegisterRequestDTO: MemberDTO): MemberResponseDTO
    fun findMembers(): List<MemberResponseDTO>
    fun findMember(memberId: Long): MemberResponseDTO
    fun updateMember(memberId: Long, requestDTO: MemberDTO): MemberResponseDTO
}