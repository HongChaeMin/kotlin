package com.example.kotlinserver.dto.author

import com.example.kotlinserver.domain.author.Book

data class BookDTO(
    val id: String,
    val title: String,
    val price: Int
) {
    fun toEntity(): Book {
        return Book(
            id = this.id,
            title = this.title,
            price = this.price
        )
    }
}
