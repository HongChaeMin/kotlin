package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long> {
}