package com.example.kotlinserver.domain

import com.example.kotlinserver.domain.Gender
import com.example.kotlinserver.domain.book.Book
import com.vladmihalcea.hibernate.type.json.JsonType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@TypeDef(name = "json", typeClass = JsonType::class)
class Author (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val gender: Gender,
    val age: Int,

    @Type(type = "json")
    @Column(columnDefinition = "json")
    val books: ArrayList<Book>
    )
