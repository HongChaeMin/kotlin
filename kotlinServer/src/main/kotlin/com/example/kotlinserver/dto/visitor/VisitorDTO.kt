package com.example.kotlinserver.dto.visitor

import com.example.kotlinserver.domain.visitor.Visitor

data class VisitorDTO(
    val visitorId: Long?,
    val userIds: List<Long>
) {
    fun toEntity(): Visitor {
        return Visitor(visitorId, userIds)
    }
}
