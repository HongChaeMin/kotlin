package com.example.kotlinserver.service

import com.example.kotlinserver.dto.MemberDTO
import com.example.kotlinserver.dto.response.MemberResponseDTO
import com.example.kotlinserver.repository.MemberRepository
import com.example.kotlinserver.util.error.ErrorCode
import com.example.kotlinserver.util.error.MemberException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class MemberServiceImpl(private val memberRepository: MemberRepository) : MemberService {

    @Transactional
    override fun registerMember(memberRegisterRequestDTO: MemberDTO): MemberResponseDTO {
        checkUserNickname(memberRegisterRequestDTO.userNickName)
        val saveMember = memberRepository.save(memberRegisterRequestDTO.toEntity())
        return saveMember.toResponseDTO()
    }

    override fun findMembers(): List<MemberResponseDTO> {
        val findMembers = memberRepository.findAll()
        return findMembers.map { member -> member.toResponseDTO() }
    }

    override fun findMember(memberId: Long): MemberResponseDTO {
        return memberRepository.findByIdOrNull(memberId)
            ?.toResponseDTO()
            ?: throw MemberException(ErrorCode.NOT_EXIST_MEMBER)
    }

    @Transactional
    override fun updateMember(memberId: Long, requestDTO: MemberDTO): MemberResponseDTO {
        val findMember = (
            memberRepository.findByIdOrNull(memberId)
                ?: throw MemberException(ErrorCode.NOT_EXIST_MEMBER)
            )
        return findMember.toResponseDTO()
    }

    @Transactional
    override fun deleteMember(memberId: Long) {
        val findMember = memberRepository.findByIdOrNull(memberId)
            ?: throw MemberException(ErrorCode.NOT_EXIST_MEMBER)
        memberRepository.delete(findMember)
    }

    private fun checkUserNickname(userNickname: String) {
        if (!memberRepository.findByUserNickName(userNickname).isEmpty)
            throw MemberException(ErrorCode.EXIST_NICK_NAME)
    }
}
