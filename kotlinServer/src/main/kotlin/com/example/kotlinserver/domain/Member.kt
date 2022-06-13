package com.example.kotlinserver.domain

import javax.persistence.*

@Entity
class Member (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var userNickName: String,
    var age: Int,
    @Enumerated(EnumType.STRING)
    var gender: Gender
) : BaseEntity()
