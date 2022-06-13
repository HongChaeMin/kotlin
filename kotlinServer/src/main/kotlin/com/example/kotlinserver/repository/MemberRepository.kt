package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>