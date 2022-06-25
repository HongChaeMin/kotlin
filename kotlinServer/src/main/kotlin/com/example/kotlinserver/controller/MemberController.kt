package com.example.kotlinserver.controller

import com.example.kotlinserver.dto.MemberDTO
import com.example.kotlinserver.dto.response.MemberResponseDTO
import com.example.kotlinserver.service.MemberService
import com.example.kotlinserver.util.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
class MemberController(private val memberService: MemberService) {

    @PostMapping(value = ["/member"], produces = ["application/json"])
    fun register(@RequestBody memberRegisterRequest: MemberDTO): ApiResponse.Success<MemberResponseDTO> {
        val saveMember = memberService.registerMember(memberRegisterRequest)
        return ApiResponse.Success(saveMember, "사용자 등록이 완료되었습니다.")
    }

    @GetMapping(value = ["/members"], produces = ["application/json"])
    fun findMembers(): ApiResponse.Success<List<MemberResponseDTO>> {
        val findMembers = memberService.findMembers()
        return ApiResponse.Success(findMembers, "사용자 목록입니다.")
    }

    @GetMapping(value = ["/member/{memberId}"], produces = ["application/json"])
    fun findMember(@PathVariable memberId: Long): ApiResponse.Success<MemberResponseDTO> {
        val findMember = memberService.findMember(memberId)
        return ApiResponse.Success(findMember, "사용자 상세입니다.")
    }

    @PatchMapping(value = ["/member/{memberId}"], produces = ["application/json"])
    fun updateMember(@PathVariable memberId: Long, requestDTO: MemberDTO): ApiResponse.Success<MemberResponseDTO> {
        val updateMember = memberService.updateMember(memberId, requestDTO)
        return ApiResponse.Success(updateMember, "사용자 수정이 완료되었습니다.")
    }

    @DeleteMapping(value = ["/member/{memberId}"], produces = ["application/json"])
    fun deleteMember(@PathVariable memberId: Long): ApiResponse.Success<String> {
        memberService.deleteMember(memberId)
        return ApiResponse.Success("OK", "사용자 삭제가 완료되었습니다.")
    }
}