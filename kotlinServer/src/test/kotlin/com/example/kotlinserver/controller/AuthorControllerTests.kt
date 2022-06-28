package com.example.kotlinserver.controller

import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.dto.author.AuthorDTO
import com.example.kotlinserver.dto.author.BookDTO
import com.example.kotlinserver.util.ApiResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTests(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
) {

    // 통합 테스트

    @Test
    fun `find one author`() {
        val authorDTO = AuthorDTO(
            id = 6L,
            name = "Hannah1",
            gender = Gender.FEMALE,
            age = 21,
            books = listOf(
                BookDTO("string-id-1", "title1", 12900),
                BookDTO("string-id-1", "title1", 12900),
                BookDTO("string-id-1", "title1", 12900)
            )
        )
        val success = ApiResponse.Success(authorDTO, "작가 & 책 목록입니다.")

        mockMvc.get("/author/6")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(objectMapper.writeValueAsString(success))
                }
            }
    }

}