package com.example.kotlinserver.domain.score

import com.example.kotlinserver.domain.member.Member
import com.example.kotlinserver.domain.util.BaseEntity
import com.example.kotlinserver.dto.score.ScoreDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Score(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,

    @Enumerated(EnumType.STRING)
    val subject: Subject,

    val score: Int,

) : BaseEntity()

enum class Subject {
    KOREAN, MATH, ENGLISH, SCIENCE
}

@Mapper
interface ScoreMapper {

    @Mappings(
        Mapping(target = "id", ignore = true),
        Mapping(target = "memberId", source = "member.id"),
        Mapping(target = "memberName", source = "member.userNickName"),
        Mapping(target = "subject", source = "score.subject"),
        Mapping(target = "score", source = "score.score"),
        Mapping(target = "creationDate", expression = "java(new java.util.Date())")
    )
    fun toScoreDto(score: Score, member: Member): ScoreDTO
}
