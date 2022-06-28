package com.example.kotlinserver.service.author

import com.example.kotlinserver.dto.author.AuthorDTO
import com.example.kotlinserver.dto.author.BookDTO

interface AuthorService {
    fun findAuthors(): List<AuthorDTO>
    fun findAuthor(authorId: Long): AuthorDTO
    fun registerAuthor(requestDTO: AuthorDTO): AuthorDTO
    fun updateBooksInAuthor(authorId: Long, requestDTO: BookDTO): AuthorDTO
    fun deleteAuthor(authorId: Long)
}
