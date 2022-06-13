package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.Article
import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.domain.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class ArticleRepositoryTests(@Autowired val memberRepository: MemberRepository, @Autowired val articleRepository: ArticleRepository) {

    val member = Member(null, "Hannar", 20, Gender.FEMALE)

    @BeforeEach
    fun saveMember() {
        memberRepository.save(member)
    }

    @AfterEach
    fun clean() {
        memberRepository.deleteAll()
        articleRepository.deleteAll()
    }

    @Test
    fun `entity save test`() {
        // given
        val article = Article(null, "articleTitle", "content", member)
        articleRepository.save(article)

        // when
        val articles = articleRepository.findAll()

        // then
        assertThat(articles[0].articleTitle).isEqualTo("articleTitle")
        assertThat(articles[0].writer.userNickName).isEqualTo(member.userNickName)
        assertThat(articles).hasSize(1)
    }

    @Test
    fun `entity delete test`() {
        // given
        val article = Article(null, "articleTitle", "content", member)
        articleRepository.save(article)
        val saveArticles = articleRepository.findAll()

        // when
        saveArticles[0].id?.let { articleRepository.deleteById(it) }
        val deleteArticles = articleRepository.findAll()

        // then
        assertThat(deleteArticles).isEmpty()
    }


}