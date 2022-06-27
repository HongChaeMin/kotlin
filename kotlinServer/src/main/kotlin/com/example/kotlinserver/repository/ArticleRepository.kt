package com.example.kotlinserver.repository

import com.example.kotlinserver.domain.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long>
