package com.example.kotlinserver.controller

import com.example.kotlinserver.dto.request.MemberRegisterRequestDTO
import com.example.kotlinserver.service.MemberService
import com.example.kotlinserver.util.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(private val memberService: MemberService) {

    @PostMapping(value = ["/sign-up"], produces = ["application/json"])
    fun register(@RequestBody memberRegisterRequest: MemberRegisterRequestDTO): ApiResponse.Success<String> {
        memberService.registerMember(memberRegisterRequest)
        return ApiResponse.Success("사용자 등록이 완료되었습니다.")
    }

}