package com.example.kotlinserver.service

import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.dto.author.AuthorDTO
import com.example.kotlinserver.dto.author.BookDTO
import com.example.kotlinserver.repository.AuthorRepository
import com.example.kotlinserver.service.author.AuthorService
import com.example.kotlinserver.service.author.AuthorServiceImpl
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthorServiceTests : BehaviorSpec({

    val authorRepository = mockk<AuthorRepository>()
    val authorService: AuthorService = AuthorServiceImpl(authorRepository)

    // 단위 테스트

    Given("register author") {
        val author = getAuthorDTO(1)

        every { authorService.registerAuthor(ofType(AuthorDTO::class)) } returns author

        When("find one author") {
            val result = withContext(Dispatchers.IO) {
                authorRepository.findByName(author.name)
            }.get().toAuthorDto()
            Then("equals author") {
                result.name shouldBe author.name
            }
        }
    }

})

val getAuthorDTO : (Int) -> AuthorDTO = {
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
