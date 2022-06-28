package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.domain.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class UserRepositoryTests(@Autowired val memberRepository: MemberRepository) {

    @BeforeEach
    fun saveMember() {
        val member = Member(null, "Hannar", 20, Gender.FEMALE)
        memberRepository.save(member)
    }

    @AfterEach
    fun clean() {
        memberRepository.deleteAll()
    }

    @Test
    fun `entity save test`() {
        // when
        val members = memberRepository.findAll()

        // then
    }

    @Test
    fun `entity delete test`() {
        // given
        val saveMembers = memberRepository.findAll()

        // when

        // then
    }
}
