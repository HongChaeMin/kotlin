package com.example.kotlinserver.domain

import javax.persistence.*

@Entity
class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var articleTitle: String,
    var content: String,

    @ManyToOne
    var writer: Member
) : BaseEntity()