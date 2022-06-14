package com.example.kotlinserver.service

import com.example.kotlinserver.dto.request.MemberRegisterRequestDTO

interface MemberService {
    fun registerMember(memberRegisterRequestDTO: MemberRegisterRequestDTO)
}