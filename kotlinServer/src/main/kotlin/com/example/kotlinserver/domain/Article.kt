package com.example.kotlinserver.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var articleTitle: String,
    var content: String,

    @ManyToOne
    var writer: Member
) : BaseEntity()
