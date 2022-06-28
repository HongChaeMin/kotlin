package com.example.kotlinserver.dto.author

import com.example.kotlinserver.domain.Author
import com.example.kotlinserver.domain.Gender

data class AuthorDTO(
    val id: Long?,
    val name: String,
    val gender: Gender,
    val age: Int,
    val books: List<BookDTO>
) {
    fun toEntity(): Author {
        return Author(
            name = this.name,
            gender = this.gender,
            age = this.age,
            books = this.books.map { bookDto -> bookDto.toEntity() }
        )
    }
}
