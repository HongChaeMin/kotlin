package com.example.kotlinserver.service

import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.dto.author.AuthorDTO
import com.example.kotlinserver.dto.author.BookDTO
import com.example.kotlinserver.repository.AuthorRepository
import com.example.kotlinserver.service.author.AuthorService
import com.example.kotlinserver.service.author.AuthorServiceImpl
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk

class AuthorServiceTests : BehaviorSpec({

    afterContainer {
        clearAllMocks()
    }

    val authorRepository = mockk<AuthorRepository>(relaxed = true, relaxUnitFun = true)
    val authorService: AuthorService = AuthorServiceImpl(authorRepository)

    Given("author가 한 명 있는 상태에서") {
        val author: AuthorDTO = getAuthorDTO(1)
        every { authorService.registerAuthor(author) } returns author

        When("모든 author list 를 조회했을 때") {
            val result = listOf<AuthorDTO>()
            every { authorService.findAuthors() } returns result

            Then("list size 는 1개여야 한다") {
                result.size shouldBe 1
            }

            Then("list의 첫번째 author는 Hannah1 이여야한다") {
                result[0].name shouldBe "Hannah1"
            }
        }
    }
})

val getAuthorDTO: (Int) -> AuthorDTO = {
    AuthorDTO(
        id = it + 0L,
        name = "Hannah$it",
        gender = Gender.FEMALE,
        age = 20 + it,
        books = listOf(
            BookDTO("string-id-$it", "title$it", 12900),
            BookDTO("string-id-$it", "title$it", 12900),
            BookDTO("string-id-$it", "title$it", 12900)
        )
    )
}
