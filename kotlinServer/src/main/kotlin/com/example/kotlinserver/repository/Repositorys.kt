package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.author.Author
import com.example.kotlinserver.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByUserNickName(userNickName: String): Optional<Member>
}

interface AuthorRepository : JpaRepository<Author, Long> {
    fun findByName(name: String): Optional<Author>
}
