package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.author.Author
import com.example.kotlinserver.domain.member.Member
import com.example.kotlinserver.domain.score.Score
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByUserNickName(userNickName: String): Optional<Member>
    fun findByIdIsIn(id: List<Long>): List<Member>
}

interface AuthorRepository : JpaRepository<Author, Long> {
    fun findByName(name: String): Optional<Author>
}

interface ScoreRepository : JpaRepository<Score, Long>
