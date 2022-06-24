package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRepository : JpaRepository<Member, Long>{
    fun findByUserNickName(userNickName: String) : Optional<Member>
}