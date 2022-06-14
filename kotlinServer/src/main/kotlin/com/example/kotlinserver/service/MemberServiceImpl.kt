package com.example.kotlinserver.service

import com.example.kotlinserver.domain.Member
import com.example.kotlinserver.dto.request.MemberRegisterRequestDTO
import com.example.kotlinserver.error.ErrorCode
import com.example.kotlinserver.error.ErrorResponse
import com.example.kotlinserver.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(private val memberRepository: MemberRepository) : MemberService {

    override fun registerMember(memberRegisterRequestDTO: MemberRegisterRequestDTO) {
        checkUserNickname(memberRegisterRequestDTO.userNickName)
        memberRepository.save(MemberRegisterRequestDTO.Of(memberRegisterRequestDTO))
    }

    private fun checkUserNickname(userNickname: String) {
        if (null != memberRepository.findByUserNickName(userNickname))
            throw ErrorResponse(ErrorCode.EXIST_STORE_NAME)
    }

}