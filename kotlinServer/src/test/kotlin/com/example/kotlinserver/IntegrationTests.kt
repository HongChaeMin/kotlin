package com.example.kotlinserver

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.get

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class IntegrationTests(@Autowired val mockMvc: MockMvc) {

    @BeforeEach
    fun setUp() {
        println("SetUp")
    }

    @AfterEach
    fun tearDown() {
        println("TearDown")
    }

    @Test
    fun `test for test`() {
        assertEquals(4 + 1, 5);
    }

    @Test
    fun `Assert status code and content`() {
        mockMvc.get("/test").andExpect {
            status { isOk() }
            content { "hello" }
        }
    }

    @Test
    fun `not found error page`() {
        mockMvc.get("/notFoundPage").andExpect {
            status { isNotFound() }
        }
    }

}