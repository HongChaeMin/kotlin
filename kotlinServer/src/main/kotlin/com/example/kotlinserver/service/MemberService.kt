package com.example.kotlinserver.service

import com.example.kotlinserver.dto.request.MemberRegisterRequestDTO
import com.example.kotlinserver.dto.response.MemberResponseDTO

interface MemberService {
    fun registerMember(memberRegisterRequestDTO: MemberRegisterRequestDTO): MemberResponseDTO
}