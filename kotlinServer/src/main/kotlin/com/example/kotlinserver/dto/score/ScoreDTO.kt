package com.example.kotlinserver.dto.score

import com.example.kotlinserver.domain.score.Subject
import java.util.Date

data class ScoreDTO(
    val id: Long?,
    val memberId: Long?,
    val memberName: String,
    val subject: Subject,
    val score: Int,
    val creationDate: Date
)
