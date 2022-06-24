package com.example.kotlinserver.service

import com.example.kotlinserver.dto.request.MemberRegisterRequestDTO
import com.example.kotlinserver.dto.response.MemberResponseDTO
import com.example.kotlinserver.util.error.ErrorCode
import com.example.kotlinserver.util.error.MemberException
import com.example.kotlinserver.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(private val memberRepository: MemberRepository) : MemberService {

    override fun registerMember(memberRegisterRequestDTO: MemberRegisterRequestDTO): MemberResponseDTO {
        checkUserNickname(memberRegisterRequestDTO.userNickName)
        val saveMember = memberRepository.save(memberRegisterRequestDTO.of())
        return saveMember.of();
    }

    private fun checkUserNickname(userNickname: String) {
        if (!memberRepository.findByUserNickName(userNickname).isEmpty)
            throw MemberException(ErrorCode.EXIST_NICK_NAME)
    }

}